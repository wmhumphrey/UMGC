import tkinter as tk
from tkinter import messagebox
import datetime
from dataclasses import dataclass
from typing import List

# ----------------------------
# Model Classes
# ----------------------------

@dataclass
class Room:
    room_number: str
    room_type: str
    price: str

@dataclass
class Reservation:
    guest_name: str
    room: Room
    start_date: datetime.date
    end_date: datetime.date
    guarantee_payment: bool

class ReservationSystem:
    """
    A simple reservation system that maintains dummy room data and a list of reservations.
    """
    def __init__(self):
        self.rooms: List[Room] = [
            Room("101", "Single", "$100"),
            Room("102", "Double", "$150"),
            Room("201", "Suite", "$250")
        ]
        self.reservations: List[Reservation] = []

    def find_available_rooms(self, start_date: datetime.date, end_date: datetime.date) -> List[Room]:
        # For this demonstration, assume all rooms are always available.
        return self.rooms

    def make_reservation(self, guest_name: str, room: Room, start_date: datetime.date,
                         end_date: datetime.date, guarantee_payment: bool) -> Reservation:
        reservation = Reservation(guest_name, room, start_date, end_date, guarantee_payment)
        self.reservations.append(reservation)
        return reservation

# ----------------------------
# View (Tkinter User Interface)
# ----------------------------

class ReservationApp(tk.Tk):
    def __init__(self, reservation_system: ReservationSystem):
        super().__init__()
        self.reservation_system = reservation_system
        self.title("Room Reservation System")
        self.geometry("600x400")

        # Data holders for the current transaction.
        self.available_rooms = []
        self.selected_room = None
        self.start_date = None
        self.end_date = None

        # Create three frames (steps) for the UI.
        self.create_step1_frame()
        self.create_step2_frame()
        self.create_step3_frame()

        # Show the first step.
        self.show_frame(self.step1_frame)

    def create_step1_frame(self):
        """Step 1: Enter Reservation Dates."""
        self.step1_frame = tk.Frame(self)
        tk.Label(self.step1_frame, text="Step 1: Enter Reservation Dates (YYYY-MM-DD)",
                 font=("Helvetica", 16)).pack(pady=10)

        input_frame = tk.Frame(self.step1_frame)
        input_frame.pack(pady=10)

        tk.Label(input_frame, text="Start Date:").grid(row=0, column=0, padx=5, pady=5)
        self.start_date_entry = tk.Entry(input_frame)
        self.start_date_entry.grid(row=0, column=1, padx=5, pady=5)

        tk.Label(input_frame, text="End Date:").grid(row=1, column=0, padx=5, pady=5)
        self.end_date_entry = tk.Entry(input_frame)
        self.end_date_entry.grid(row=1, column=1, padx=5, pady=5)

        tk.Button(self.step1_frame, text="Find Available Rooms", command=self.find_rooms)\
            .pack(pady=10)

    def create_step2_frame(self):
        """Step 2: Display Available Rooms."""
        self.step2_frame = tk.Frame(self)
        tk.Label(self.step2_frame, text="Step 2: Available Rooms",
                 font=("Helvetica", 16)).pack(pady=10)

        self.rooms_listbox = tk.Listbox(self.step2_frame, width=50, height=10)
        self.rooms_listbox.pack(pady=10)

        button_frame = tk.Frame(self.step2_frame)
        button_frame.pack(pady=10)
        tk.Button(button_frame, text="Change Dates", command=self.reset_to_step1)\
            .grid(row=0, column=0, padx=5)
        tk.Button(button_frame, text="Select Room", command=self.select_room)\
            .grid(row=0, column=1, padx=5)

    def create_step3_frame(self):
        """Step 3: Complete the Reservation."""
        self.step3_frame = tk.Frame(self)
        tk.Label(self.step3_frame, text="Step 3: Complete Reservation",
                 font=("Helvetica", 16)).pack(pady=10)

        self.selected_room_label = tk.Label(self.step3_frame, text="Selected Room:")
        self.selected_room_label.pack(pady=5)

        guest_frame = tk.Frame(self.step3_frame)
        guest_frame.pack(pady=5)
        tk.Label(guest_frame, text="Guest Name:").grid(row=0, column=0, padx=5, pady=5)
        self.guest_name_entry = tk.Entry(guest_frame, width=30)
        self.guest_name_entry.grid(row=0, column=1, padx=5, pady=5)

        self.guarantee_var = tk.IntVar()
        tk.Checkbutton(self.step3_frame, text="1-Day Guarantee Payment",
                       variable=self.guarantee_var).pack(pady=5)

        button_frame = tk.Frame(self.step3_frame)
        button_frame.pack(pady=10)
        tk.Button(button_frame, text="Back", command=self.back_to_step2)\
            .grid(row=0, column=0, padx=5)
        tk.Button(button_frame, text="Complete Reservation", command=self.complete_reservation)\
            .grid(row=0, column=1, padx=5)

    def show_frame(self, frame):
        """Helper method to display the given frame and hide the others."""
        frame.pack(fill="both", expand=True)
        for child in self.winfo_children():
            if child is not frame:
                child.pack_forget()

    def find_rooms(self):
        """Validate dates, query available rooms from the model, and show Step 2."""
        start_date_str = self.start_date_entry.get().strip()
        end_date_str = self.end_date_entry.get().strip()
        if not start_date_str or not end_date_str:
            messagebox.showerror("Error", "Please enter both start and end dates.")
            return

        try:
            start_date = datetime.datetime.strptime(start_date_str, "%Y-%m-%d").date()
            end_date = datetime.datetime.strptime(end_date_str, "%Y-%m-%d").date()
        except ValueError:
            messagebox.showerror("Error", "Dates must be in YYYY-MM-DD format.")
            return

        if start_date > end_date:
            messagebox.showerror("Error", "Start date must be before or equal to end date.")
            return

        self.start_date = start_date
        self.end_date = end_date

        # Use the model to find available rooms.
        self.available_rooms = self.reservation_system.find_available_rooms(start_date, end_date)
        self.rooms_listbox.delete(0, tk.END)
        if not self.available_rooms:
            self.rooms_listbox.insert(tk.END, "No available rooms. Please change dates.")
        else:
            for room in self.available_rooms:
                room_text = f"Room {room.room_number} - {room.room_type} - {room.price}"
                self.rooms_listbox.insert(tk.END, room_text)
        self.show_frame(self.step2_frame)

    def select_room(self):
        """Handle the room selection and move to Step 3."""
        selected_indices = self.rooms_listbox.curselection()
        if not selected_indices:
            messagebox.showerror("Error", "Please select a room.")
            return
        index = selected_indices[0]
        self.selected_room = self.available_rooms[index]
        self.selected_room_label.config(
            text=f"Selected Room: {self.selected_room.room_number} ({self.selected_room.room_type}) - {self.selected_room.price}"
        )
        self.guest_name_entry.delete(0, tk.END)
        self.guarantee_var.set(0)
        self.show_frame(self.step3_frame)

    def back_to_step2(self):
        """Return from Step 3 to Step 2."""
        self.show_frame(self.step2_frame)

    def complete_reservation(self):
        """Complete the reservation by passing data to the model and showing a confirmation."""
        guest_name = self.guest_name_entry.get().strip()
        if not guest_name:
            messagebox.showerror("Error", "Please enter the guest's name.")
            return
        guarantee_payment = bool(self.guarantee_var.get())

        # Create a reservation in the model.
        reservation = self.reservation_system.make_reservation(
            guest_name, self.selected_room, self.start_date, self.end_date, guarantee_payment
        )
        messagebox.showinfo("Reservation Complete",
            f"Reservation completed for {reservation.guest_name}.\n"
            f"Room: {reservation.room.room_number} ({reservation.room.room_type}) - {reservation.room.price}\n"
            f"Guarantee Payment: {'Yes' if reservation.guarantee_payment else 'No'}"
        )
        self.reset_to_step1()

    def reset_to_step1(self):
        """Reset all fields and return to Step 1."""
        self.start_date_entry.delete(0, tk.END)
        self.end_date_entry.delete(0, tk.END)
        self.rooms_listbox.delete(0, tk.END)
        self.guest_name_entry.delete(0, tk.END)
        self.guarantee_var.set(0)
        self.selected_room = None
        self.show_frame(self.step1_frame)

# ----------------------------
# Main: Run the Application
# ----------------------------

if __name__ == "__main__":
    reservation_system = ReservationSystem()
    app = ReservationApp(reservation_system)
    app.mainloop()
