CREATE DEFINER = root@localhost PROCEDURE validate_booking_date (IN room_id INT, IN start_booking_date DATE, IN end_booking_date DATE)
BEGIN
    DECLARE validate INT DEFAULT 0;

SELECT 1 INTO validate
FROM hotel.bookings b
WHERE b.room_id = room_id
  AND b.delete_date IS NULL
  AND (
        (start_booking_date BETWEEN b.start_date AND b.end_date)
        OR (end_booking_date BETWEEN b.start_date AND b.end_date)
        OR (b.start_date BETWEEN start_booking_date AND end_booking_date)
        OR (b.end_date BETWEEN start_booking_date AND end_booking_date)
        OR (b.start_date = start_booking_date OR b.start_date = end_booking_date)
        OR (b.end_date = start_booking_date OR b.end_date = end_booking_date)
    )
    LIMIT 1;

SELECT validate;
END;