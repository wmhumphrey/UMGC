import tkinter as tk
from tkinter import messagebox
import datetime

# Dummy data for available rooms.
dummy_rooms = [
    {'roomNumber': '101', 'type': 'Single', 'price': '$100'},
    {'roomNumber': '102', 'type': 'Double', 'price': '$150'},
    {'roomNumber': '201', 'type': 'Suite', 'price': '$250'}
]

# Global variable to hold the selected room.
current_selected_room = None


def find_rooms():
    """Step 1: Validate dates and show available rooms (Step 2)."""
    start_date_str = start_date_entry.get().strip()
    end_date_str = end_date_entry.get().strip()

    if not start_date_str or not end_date_str:
        messagebox.showerror("Error", "Please enter both start and end dates.")
        return

    try:
        start_date = datetime.datetime.strptime(start_date_str, "%Y-%m-%d")
        end_date = datetime.datetime.strptime(end_date_str, "%Y-%m-%d")
    except ValueError:
        messagebox.showerror("Error", "Dates must be in YYYY-MM-DD format.")
        return

    if start_date > end_date:
        messagebox.showerror("Error", "Start date must be before or equal to end date.")
        return

    # For demonstration, we simply use our dummy room list.
    available_rooms = dummy_rooms

    # Populate the listbox in Step 2 with available room details.
    room_listbox.delete(0, tk.END)
    if not available_rooms:
        room_listbox.insert(tk.END, "No available rooms. Please change dates.")
    else:
        for room in available_rooms:
            room_info = f"Room {room['roomNumber']} - {room['type']} - {room['price']}"
            room_listbox.insert(tk.END, room_info)

    # Hide Step 1 and show Step 2.
    step1_frame.pack_forget()
    step3_frame.pack_forget()
    step2_frame.pack(padx=20, pady=20)


def select_room():
    """Step 2: When a room is selected, move to Step 3 for completion."""
    selected_indices = room_listbox.curselection()
    if not selected_indices:
        messagebox.showerror("Error", "Please select a room.")
        return
    index = selected_indices[0]
    global current_selected_room
    current_selected_room = dummy_rooms[index]

    # Update the label in Step 3 to show the selected room.
    selected_room_label.config(
        text=f"Selected Room: {current_selected_room['roomNumber']} - {current_selected_room['type']} - {current_selected_room['price']}"
    )
    guest_name_entry.delete(0, tk.END)
    payment_var.set(0)

    # Hide Step 2 and show Step 3.
    step2_frame.pack_forget()
    step3_frame.pack(padx=20, pady=20)


def complete_reservation():
    """Step 3: Complete the reservation using the guest's name and payment option."""
    guest_name = guest_name_entry.get().strip()
    if not guest_name:
        messagebox.showerror("Error", "Please enter the guest's name.")
        return

    guarantee_payment = bool(payment_var.get())
    # In a full application, here you would save the reservation details.
    messagebox.showinfo(
        "Reservation Complete",
        f"Reservation completed for {guest_name}.\n"
        f"Selected Room: {current_selected_room['roomNumber']} - {current_selected_room['type']} - {current_selected_room['price']}\n"
        f"Guarantee Payment: {'Yes' if guarantee_payment else 'No'}"
    )
    restart_reservation()


def back_to_rooms():
    """Allow the clerk to go back from Step 3 to Step 2 to choose a different room."""
    step3_frame.pack_forget()
    step2_frame.pack(padx=20, pady=20)


def restart_reservation():
    """Reset the form and return to Step 1 (enter dates)."""
    start_date_entry.delete(0, tk.END)
    end_date_entry.delete(0, tk.END)
    room_listbox.delete(0, tk.END)
    guest_name_entry.delete(0, tk.END)
    payment_var.set(0)

    step2_frame.pack_forget()
    step3_frame.pack_forget()
    step1_frame.pack(padx=20, pady=20)


# Main application window.
root = tk.Tk()
root.title("Room Reservation")

# ----- Step 1: Enter Reservation Dates -----
step1_frame = tk.Frame(root)
tk.Label(step1_frame, text="Step 1: Enter Reservation Dates", font=("Helvetica", 16)).pack(pady=10)

tk.Label(step1_frame, text="Start Date (YYYY-MM-DD):").pack()
start_date_entry = tk.Entry(step1_frame)
start_date_entry.pack(pady=5)

tk.Label(step1_frame, text="End Date (YYYY-MM-DD):").pack()
end_date_entry = tk.Entry(step1_frame)
end_date_entry.pack(pady=5)

tk.Button(step1_frame, text="Find Available Rooms", command=find_rooms).pack(pady=10)

# ----- Step 2: Display Available Rooms -----
step2_frame = tk.Frame(root)
tk.Label(step2_frame, text="Step 2: Available Rooms", font=("Helvetica", 16)).pack(pady=10)

room_listbox = tk.Listbox(step2_frame, width=50, height=10)
room_listbox.pack(pady=10)

# Buttons for Step 2.
step2_buttons = tk.Frame(step2_frame)
step2_buttons.pack(pady=10)
tk.Button(step2_buttons, text="Select Room", command=select_room).pack(side=tk.LEFT, padx=10)
tk.Button(step2_buttons, text="Change Dates", command=restart_reservation).pack(side=tk.LEFT, padx=10)

# ----- Step 3: Complete Reservation Details -----
step3_frame = tk.Frame(root)
tk.Label(step3_frame, text="Step 3: Complete Reservation", font=("Helvetica", 16)).pack(pady=10)

selected_room_label = tk.Label(step3_frame, text="Selected Room:")
selected_room_label.pack(pady=5)

tk.Label(step3_frame, text="Guest Name:").pack()
guest_name_entry = tk.Entry(step3_frame)
guest_name_entry.pack(pady=5)

payment_var = tk.IntVar()
tk.Checkbutton(step3_frame, text="1-Day Guarantee Payment", variable=payment_var).pack(pady=5)

# Buttons for Step 3.
step3_buttons = tk.Frame(step3_frame)
step3_buttons.pack(pady=10)
tk.Button(step3_buttons, text="Complete Reservation", command=complete_reservation).pack(side=tk.LEFT, padx=10)
tk.Button(step3_buttons, text="Back", command=back_to_rooms).pack(side=tk.LEFT, padx=10)

# Show the initial frame.
step1_frame.pack(padx=20, pady=20)

root.mainloop()
