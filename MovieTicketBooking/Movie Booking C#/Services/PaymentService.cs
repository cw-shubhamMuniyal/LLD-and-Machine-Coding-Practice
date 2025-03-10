using System.Data.Common;
using MovieTicketBooking.Model;
using MovieTicketBooking.Providers;

namespace MovieTicketBooking.Services
{
    public class PaymentService
    {
        BookingService _bookingService;
        ISeatLockProvider _seatLockProvider;
        int _allowedRetries;
        Dictionary<string, int> _bookingFailures = new();
        public PaymentService(BookingService bookingService, ISeatLockProvider seatLockProvider,
        int allowedRetries)
        {
            _bookingService = bookingService;
            _seatLockProvider = seatLockProvider;
            _allowedRetries = allowedRetries;
        }
        public void ProcessPaymentFailed(string userId, string bookingId)
        {
            Booking booking = _bookingService.GetBooking(bookingId);
            if (!booking.User.Equals(userId))
            {
                throw new Exception("this booking is not made by give user id");
            }
            if (_bookingFailures.ContainsKey(bookingId))
            {
                if (_bookingFailures.GetValueOrDefault(bookingId) > _allowedRetries)
                {
                    throw new Exception("max retries done");
                }
            }
            if (!_bookingFailures.ContainsKey(bookingId))
            {
                _bookingFailures.Add(bookingId, 0);
            }
            else
            {
                _bookingFailures.Add(bookingId, _bookingFailures.GetValueOrDefault(bookingId) + 1);
            }
            if (_bookingFailures.GetValueOrDefault(bookingId) < _allowedRetries)
            {
                _seatLockProvider.UnlockSeat(booking.Show, booking.Seats, userId);
            }
        }
    }
}