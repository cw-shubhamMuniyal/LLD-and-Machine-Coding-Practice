using inventoryManagementSystem.Model;

namespace inventoryManagementSystem.Controllers
{
    public class UserController
    {
        List<User> Users = new();
        public UserController()
        {
        }
        public void AddUser(string id, Address address)
        {
            Users.Add(new User(id, address));
        }
        public void RemoveUser(string id)
        {
            Users.RemoveAll(user => user.Id == id);
        }
        public User GetUser(string id)
        {
            return Users.Where(user => user.Id == id).FirstOrDefault();
        }
    }
}