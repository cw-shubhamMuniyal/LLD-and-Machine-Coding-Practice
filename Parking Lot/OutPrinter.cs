

/**
 * Printer to help in printing the output back to the user. Output medium can be changed here
 * anytime without affecting any of the other code. Currently, System.out is used. Tomorrow if file
 * has to be used to output, it can be changed here easily.
 */
public class OutputPrinter
{

    public void Welcome()
    {
        PrintWithNewLine("Welcome to Go-Jek Parking lot.");
    }

    public void End()
    {
        PrintWithNewLine("Thanks for using Go-Jek Parking lot service.");
    }

    public void NotFound()
    {
        PrintWithNewLine("Not found");
    }

    public void statusHeader()
    {
        PrintWithNewLine("Slot No.    Registration No    Colour");
    }

    public void ParkingLotFull()
    {
        PrintWithNewLine("Sorry, parking lot is full");
    }

    public void ParkingLotEmpty()
    {
        PrintWithNewLine("Parking lot is empty");
    }

    public void InvalidFile()
    {
        PrintWithNewLine("Invalid file given.");
    }

    public void PrintWithNewLine(string msg)
    {
        Console.WriteLine(msg);
    }
}