using System.Security.Cryptography;
using Exceptions;
using Model;
using Model.Parking.Strategy;

namespace Service
{

    /**
     * Service for enable the functioning of a parking lot. This will have all the business logic of
     * how the parking service will operate.
     */
    public class ParkingLotService
    {
        private ParkingLot ParkingLot;
        private ParkingStrategy ParkingStrategy;

        /**
         * Allots a parking lot into the parking service. Throwns {@link ParkingLotException} if there is
         * already a parking lot alloted to the service previously.
         *
         * @param parkingLot Parking lot to be alloted.
         * @param parkingStrategy Strategy to be used while parking.
         */
        public void createParkingLot( ParkingLot parkingLot,  ParkingStrategy parkingStrategy)
        {
            if (this.ParkingLot != null)
            {
                throw new ParkingLotException("Parking lot already exists.");
            }
            this.ParkingLot = parkingLot;
            this.ParkingStrategy = parkingStrategy;
            for (int i = 1; i <= parkingLot.Capacity; i++)
            {
                parkingStrategy.AddSlot(i);
            }
        }

        /**
         * Parks a {@link Car} into the parking lot. {@link ParkingStrategy} is used to decide the slot
         * number and then the car is parked into the {@link ParkingLot} into that slot number.
         *
         * @param car Car to be parked.
         * @return Slot number in which the car is parked.
         */
        public int Park( Car car)
        {
            validateParkingLotExists();
            int nextFreeSlot = ParkingStrategy.GetNextSlot();
            ParkingLot.park(car, nextFreeSlot);
            ParkingStrategy.RemoveSlot(nextFreeSlot);
            return nextFreeSlot;
        }

        /**
         * Unparks a car from a slot. Freed slot number is given back to the parking strategy so that it
         * becomes available for future parkings.
         *
         * @param slotNumber Slot number to be freed.
         */
        public void MakeSlotFree(int slotNumber)
        {
            validateParkingLotExists();
            ParkingLot.makeSlotFree(slotNumber);
            ParkingStrategy.AddSlot(slotNumber);
        }

        /**
         * Gets the list of all the slots which are occupied.
         */
        public List<Slot> GetOccupiedSlots()
        {
            validateParkingLotExists();
             List<Slot> occupiedSlotsList = new List<Slot>();
             Dictionary<int, Slot> allSlots = ParkingLot.Slots;

            for (int i = 1; i <= ParkingLot.Capacity; i++)
            {
                if (allSlots.ContainsKey(i))
                {
                    _ = allSlots.TryGetValue(i, out Slot slot);
                    if (!slot.IsSlotFree())
                    {
                        occupiedSlotsList.Add(slot);
                    }
                }
            }

            return occupiedSlotsList;
        }

        /**
         * Helper method to validate whether the parking lot exists or not. This is used to validate the
         * existence of parking lot before doing any operation on it.
         */
        private void validateParkingLotExists()
        {
            if (ParkingLot == null)
            {
                throw new ParkingLotException("Parking lot does not exists to park.");
            }
        }

        /**
         * Gets all the slots in which a car with given color is parked.
         *
         * @param color Color to be searched.
         * @return All matching slots.
         */
        public List<Slot> getSlotsForColor( String color)
        {
             List<Slot> occupiedSlots = GetOccupiedSlots();
            return occupiedSlots
                .Where(slot => slot.ParkedCar.Color.Equals(color))
                .ToList();
        }


    }
}