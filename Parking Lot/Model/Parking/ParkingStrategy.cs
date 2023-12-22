namespace Model.Parking.Strategy
{
    /**
     * Strategy which will be used to decide how slots will be used to park the car.
     */
    public interface ParkingStrategy
    {

        /**
         * Add a new slot to parking strategy. After adding, this new slot will become available for
         * future parkings.
         *
         * @param slotNumber Slot number to be added.
         */
        public void AddSlot(int slotNumber);

        /**
         * Removes a slot from the parking strategy. After removing, this slot will not be used for future
         * parkings.
         *
         * @param slotNumber Slot number to be removed.
         */
        public void RemoveSlot(int slotNumber);

        /**
         * Get the next free slot as per the parking strategy.
         *
         * @return Next free slot number.
         */
        public int GetNextSlot();
    }
}
