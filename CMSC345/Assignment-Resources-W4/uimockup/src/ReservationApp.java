import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationApp extends JFrame {

    // CardLayout for switching between steps.
    private CardLayout cardLayout;
    private JPanel cardPanel;

    // Step 1 components (date selection).
    private JTextField startDateField, endDateField;

    // Step 2 components (room selection).
    private DefaultListModel<Room> roomListModel;
    private JList<Room> roomList;

    // Step 3 components (reservation details).
    private JLabel selectedRoomLabel;
    private JTextField guestNameField;
    private JCheckBox guaranteeCheckBox;

    // Holds the currently selected room.
    private Room selectedRoom;

    // Dummy room data.
    private ArrayList<Room> dummyRooms;

    // Date format (expects YYYY-MM-DD).
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ReservationApp() {
        setTitle("Room Reservation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Initialize the CardLayout and main panel.
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create dummy room data.
        dummyRooms = new ArrayList<>();
        dummyRooms.add(new Room("101", "Single", "$100"));
        dummyRooms.add(new Room("102", "Double", "$150"));
        dummyRooms.add(new Room("201", "Suite", "$250"));

        // Add the three steps as cards.
        cardPanel.add(createStep1Panel(), "Step1");
        cardPanel.add(createStep2Panel(), "Step2");
        cardPanel.add(createStep3Panel(), "Step3");

        add(cardPanel);
    }

    // ------------------------
    // Step 1: Enter Dates Panel
    // ------------------------
    private JPanel createStep1Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel header = new JLabel("Step 1: Enter Reservation Dates (YYYY-MM-DD)");
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(header);

        // Input panel for dates.
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Start Date:"));
        startDateField = new JTextField(10);
        inputPanel.add(startDateField);

        inputPanel.add(new JLabel("End Date:"));
        endDateField = new JTextField(10);
        inputPanel.add(endDateField);
        panel.add(inputPanel);

        // Button to proceed.
        JButton findRoomsButton = new JButton("Find Available Rooms");
        findRoomsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        findRoomsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findRooms();
            }
        });
        panel.add(findRoomsButton);

        return panel;
    }

    // ------------------------
    // Step 2: Available Rooms Panel
    // ------------------------
    private JPanel createStep2Panel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel header = new JLabel("Step 2: Available Rooms", SwingConstants.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(header, BorderLayout.NORTH);

        roomListModel = new DefaultListModel<>();
        roomList = new JList<>(roomListModel);
        roomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        roomList.setCellRenderer(new RoomListCellRenderer());

        JScrollPane scrollPane = new JScrollPane(roomList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Buttons panel.
        JPanel buttonPanel = new JPanel();
        JButton changeDatesButton = new JButton("Change Dates");
        changeDatesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetToStep1();
            }
        });
        JButton selectRoomButton = new JButton("Select Room");
        selectRoomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectRoom();
            }
        });
        buttonPanel.add(changeDatesButton);
        buttonPanel.add(selectRoomButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    // ------------------------
    // Step 3: Complete Reservation Panel
    // ------------------------
    private JPanel createStep3Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel header = new JLabel("Step 3: Complete Reservation");
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(header);

        selectedRoomLabel = new JLabel("Selected Room: ");
        selectedRoomLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(selectedRoomLabel);

        JPanel guestPanel = new JPanel(new FlowLayout());
        guestPanel.add(new JLabel("Guest Name:"));
        guestNameField = new JTextField(20);
        guestPanel.add(guestNameField);
        panel.add(guestPanel);

        guaranteeCheckBox = new JCheckBox("1-Day Guarantee Payment");
        guaranteeCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(guaranteeCheckBox);

        // Button panel.
        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Step2");
            }
        });
        JButton completeButton = new JButton("Complete Reservation");
        completeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                completeReservation();
            }
        });
        buttonPanel.add(backButton);
        buttonPanel.add(completeButton);
        panel.add(buttonPanel);

        return panel;
    }

    // ------------------------
    // Action Methods
    // ------------------------

    // Step 1: Validate dates and populate available rooms.
    private void findRooms() {
        String startDateStr = startDateField.getText().trim();
        String endDateStr = endDateField.getText().trim();
        Date startDate, endDate;
        try {
            startDate = dateFormat.parse(startDateStr);
            endDate = dateFormat.parse(endDateStr);
        } catch (ParseException pe) {
            JOptionPane.showMessageDialog(this,
                    "Please enter dates in YYYY-MM-DD format.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (startDate.after(endDate)) {
            JOptionPane.showMessageDialog(this,
                    "Start date must be before or equal to end date.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // For demonstration, use dummyRooms.
        roomListModel.clear();
        for (Room room : dummyRooms) {
            roomListModel.addElement(room);
        }

        cardLayout.show(cardPanel, "Step2");
    }

    // Step 2: Select a room from the list.
    private void selectRoom() {
        selectedRoom = roomList.getSelectedValue();
        if (selectedRoom == null) {
            JOptionPane.showMessageDialog(this,
                    "Please select a room.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        selectedRoomLabel.setText("Selected Room: " + selectedRoom);
        guestNameField.setText("");
        guaranteeCheckBox.setSelected(false);
        cardLayout.show(cardPanel, "Step3");
    }

    // Step 3: Complete the reservation.
    private void completeReservation() {
        String guestName = guestNameField.getText().trim();
        if (guestName.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter the guest's name.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean guaranteePayment = guaranteeCheckBox.isSelected();

        String message = "Reservation completed for " + guestName + ".\n" +
                "Selected Room: " + selectedRoom + "\n" +
                "Guarantee Payment: " + (guaranteePayment ? "Yes" : "No");
        JOptionPane.showMessageDialog(this, message, "Reservation Complete", JOptionPane.INFORMATION_MESSAGE);

        resetToStep1();
    }

    // Reset all fields and go back to Step 1.
    private void resetToStep1() {
        startDateField.setText("");
        endDateField.setText("");
        roomListModel.clear();
        guestNameField.setText("");
        guaranteeCheckBox.setSelected(false);
        selectedRoom = null;
        cardLayout.show(cardPanel, "Step1");
    }

    // ------------------------
    // Custom ListCellRenderer for Room objects.
    // ------------------------
    private class RoomListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Room) {
                Room room = (Room) value;
                setText("Room " + room.getRoomNumber() + " - " + room.getType() + " - " + room.getPrice());
            }
            return this;
        }
    }

    // ------------------------
    // Room Model Class
    // ------------------------
    private static class Room {
        private String roomNumber;
        private String type;
        private String price;

        public Room(String roomNumber, String type, String price) {
            this.roomNumber = roomNumber;
            this.type = type;
            this.price = price;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public String getType() {
            return type;
        }

        public String getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return roomNumber + " (" + type + ") - " + price;
        }
    }

    // ------------------------
    // Main Method
    // ------------------------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ReservationApp app = new ReservationApp();
                app.setVisible(true);
            }
        });
    }
}
