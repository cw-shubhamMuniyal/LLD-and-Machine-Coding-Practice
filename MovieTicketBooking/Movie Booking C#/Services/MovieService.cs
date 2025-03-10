using System;
using MovieTicketBooking.Model;

namespace MovieTicketBooking.Services
{
    public class MovieService
    {
        Dictionary<string, Movie> movies = new();

        public string AddMovie(string name)
        {
            string id = Guid.NewGuid().ToString();
            if(movies.ContainsKey(id))
            {
                throw new Exception("movie with this id already exists");
            }
            movies.Add(id, new Movie(id, name));
            return id;
        }
        public Movie GetMovie(string movieId)
        {
            if(!movies.ContainsKey(movieId))
            {
                throw new Exception("movie with this id not exists");
            }
            return movies.GetValueOrDefault(movieId);
        }
    }
}