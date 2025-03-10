namespace MovieTicketBooking.Model
{
    public class Theatre
    {
        string Id { get; }
        string Name;
        List<Screen> screens = new();
        public Theatre(string id, string name)
        {
            this.Id = id;
            this.Name = name;
        }
        public void AddScreen(Screen screen)
        {
            screens.Add(screen);
        }
    }
}