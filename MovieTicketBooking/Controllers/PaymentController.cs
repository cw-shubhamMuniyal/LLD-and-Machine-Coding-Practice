using MovieTicketBooking.Services;

namespace MovieTicketBooking.Controllers
{

    public class PaymentController
    {
        BookingService _bookingService;
        PaymentService _paymentService;
        public PaymentController(BookingService bookingService, PaymentService paymentService)
        {
            _bookingService = bookingService;
            _paymentService = paymentService;
        }
        public void ProcessPaymentSuccess(string user, string bookingId)
        {
            _bookingService.ConfrimBooking(bookingId, user);
        }
        public void ProcessPaymentFailed(string user, string bookingId)
        {
           _paymentService.ProcessPaymentFailed(user, bookingId);
        }
    }
}