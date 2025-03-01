namespace Model
{
    public class Car
    {
        public string? RegistrationNumber { get; set; }
        public string? Color { get; set; }

        public Car(string registrationNumber, string color)
        {
            RegistrationNumber = registrationNumber;
            Color = color;
        }
    }
}