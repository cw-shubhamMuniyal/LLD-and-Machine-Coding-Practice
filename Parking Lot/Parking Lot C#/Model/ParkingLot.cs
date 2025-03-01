
using System.Collections.Generic;
using Exceptions;

namespace Model
{/**
 * Model object to represent the functioning of a parking lot.
 */
    public class ParkingLot
    {
        private const int MAX_CAPACITY = 100000;
        public int Capacity { get; set; }
        public Dictionary<int, Slot> Slots { get; } = [];


        public ParkingLot(int capacity)
        {
            if (capacity > MAX_CAPACITY || capacity <= 0)
            {
                throw new ParkingLotException("Invalid capacity given for parking lot.");
            }
            this.Capacity = capacity;
        }

        /**
   * Helper method to get a {@link Slot} object for a given slot number. If slot does not exists,
   * then new slot will be created before giving it back.
   *
   * @param slotNumber Slot number.
   * @return Slot.
   */
        private Slot getSlot(int slotNumber)
        {
            if (slotNumber > MAX_CAPACITY || slotNumber <= 0)
            {
                throw new InvalidSlotException();
            }
            Dictionary<int, Slot> allSlots = this.Slots;
            if (!allSlots.ContainsKey(slotNumber))
            {
                allSlots.Add(slotNumber, new Slot(slotNumber));
            }
            _ = allSlots.TryGetValue(slotNumber, out Slot slot);
            return slot;
        }

        /**
 * Parks a car into a given slot number.
 *
 * @param car Car to be parked.
 * @param slotNumber Slot number in which it has to be parked.
 * @return {@link Slot} if the parking succeeds. If the slot is already occupied then {@link
 *     SlotAlreadyOccupiedException} is thrown.
 */
        public Slot park(Car car, int slotNumber)
        {
            Slot slot = getSlot(slotNumber);
            if (!slot.IsSlotFree())
            {
                throw new SlotAlreadyOccupiedException();
            }
            slot.AssignCar(car);
            return slot;
        }

        /**
 * Makes the slot free from the current parked car.
 *
 * @param slotNumber Slot number to be freed.
 * @return Freed slot.
 */
        public Slot makeSlotFree(int slotNumber)
        {
            Slot slot = getSlot(slotNumber);
            slot.UnassignCar();
            return slot;
        }
    }
}