package domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Jelena Basaric
 */
public class Bill {
    private long InvoiceNo;
    private Registration registration;
    private Guest guest;
    private BigDecimal roomCharge;
    private BigDecimal roomService;
    private BigDecimal restaurantCharges;
    private BigDecimal miscCharges;
    private BigDecimal barCharges;
    private boolean ifLateCheckout;
    private BigDecimal sumCharges;
    private LocalDate paymentDate;
    private PaymentMode paymentMode;

    public Bill(long InvoiceNo, Registration registration, Guest guest) {
        this.InvoiceNo = InvoiceNo;
        this.registration = registration;
        this.guest = guest;
    }

    public Bill(long InvoiceNo, Registration registration, Guest guest, BigDecimal roomCharge, BigDecimal roomService, BigDecimal restaurantCharges, BigDecimal miscCharges, BigDecimal barCharges, boolean ifLateCheckout, BigDecimal sumCharges, LocalDate paymentDate, PaymentMode paymentMode) {
        this.InvoiceNo = InvoiceNo;
        this.registration = registration;
        this.guest = guest;
        this.roomCharge = roomCharge;
        this.roomService = roomService;
        this.restaurantCharges = restaurantCharges;
        this.miscCharges = miscCharges;
        this.barCharges = barCharges;
        this.ifLateCheckout = ifLateCheckout;
        this.sumCharges = sumCharges;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
    }
    

    public long getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(long InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public BigDecimal getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(BigDecimal roomCharge) {
        this.roomCharge = roomCharge;
    }

    public BigDecimal getRoomService() {
        return roomService;
    }

    public void setRoomService(BigDecimal roomService) {
        this.roomService = roomService;
    }

    public BigDecimal getRestaurantCharges() {
        return restaurantCharges;
    }

    public void setRestaurantCharges(BigDecimal restaurantCharges) {
        this.restaurantCharges = restaurantCharges;
    }

    public BigDecimal getMiscCharges() {
        return miscCharges;
    }

    public void setMiscCharges(BigDecimal miscCharges) {
        this.miscCharges = miscCharges;
    }

    public BigDecimal getBarCharges() {
        return barCharges;
    }

    public void setBarCharges(BigDecimal barCharges) {
        this.barCharges = barCharges;
    }

    public boolean isIfLateCheckout() {
        return ifLateCheckout;
    }

    public void setIfLateCheckout(boolean ifLateCheckout) {
        this.ifLateCheckout = ifLateCheckout;
    }

    public BigDecimal getSumCharges() {
        return sumCharges;
    }

    public void setSumCharges(BigDecimal SumCharges) {
      this.sumCharges=sumCharges;
      
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
    
    
    
}
