using ATM.ATMStates;

namespace ATM
{
    public class Atm
    {
        private static Atm atmObject = new Atm(); // Singleton: eager initialization

        private ATMState currentATMState;
        private int atmBalance;
        private int noOfTwoThousandNotes;
        private int noOfFiveHundredNotes;
        private int noOfOneHundredNotes;

        private Atm() { }

        public void SetCurrentATMState(ATMState currentATMState)
        {
            this.currentATMState = currentATMState;
        }

        public ATMState GetCurrentATMState()
        {
            return currentATMState;
        }

        public static Atm GetATMObject()
        {
            atmObject.SetCurrentATMState(new IdleState());
            return atmObject;
        }

        public int GetAtmBalance()
        {
            return atmBalance;
        }

        public void SetAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes)
        {
            this.atmBalance = atmBalance;
            this.noOfTwoThousandNotes = noOfTwoThousandNotes;
            this.noOfFiveHundredNotes = noOfFiveHundredNotes;
            this.noOfOneHundredNotes = noOfOneHundredNotes;
        }

        public int GetNoOfTwoThousandNotes()
        {
            return noOfTwoThousandNotes;
        }

        public int GetNoOfFiveHundredNotes()
        {
            return noOfFiveHundredNotes;
        }

        public int GetNoOfOneHundredNotes()
        {
            return noOfOneHundredNotes;
        }

        public void DeductATMBalance(int amount)
        {
            atmBalance -= amount;
        }

        public void AddAmount(int amount)
        {
            atmBalance += amount;
        }

        public void DeductTwoThousandNotes(int number)
        {
            noOfTwoThousandNotes -= number;
        }

        public void DeductFiveHundredNotes(int number)
        {
            noOfFiveHundredNotes -= number;
        }

        public void DeductOneHundredNotes(int number)
        {
            noOfOneHundredNotes -= number;
        }

        public void AddTwoThousandNotes(int number)
        {
            noOfTwoThousandNotes += number;
        }

        public void AddFiveHundredNotes(int number)
        {
            noOfFiveHundredNotes += number;
        }

        public void AddOneHundredNotes(int number)
        {
            noOfOneHundredNotes += number;
        }

        public void PrintCurrentATMStatus()
        {
            Console.WriteLine("Balance: " + atmBalance);
            Console.WriteLine("2kNotes: " + noOfTwoThousandNotes);
            Console.WriteLine("500Notes: " + noOfFiveHundredNotes);
            Console.WriteLine("100Notes: " + noOfOneHundredNotes);
        }
    }
}
