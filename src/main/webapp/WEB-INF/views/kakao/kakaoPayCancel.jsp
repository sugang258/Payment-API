<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cancel</title>
</head>
<body>
    결제 취소 완료<br>
    결제일시 : ${cancel.approved_at}<br>
    취소일시 : ${cancel.canceled_at}<br>
    주문번호 : ${cancel.partner_order_id}<br>
    상품명 : ${cancel.item_name}<br>
    상품수량 : ${cancel.quantity}<br>
    취소금액 : ${cancel.amount.total}
</body>
</html>