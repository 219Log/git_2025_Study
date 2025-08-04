package calss1.ex;



public class ProductOderMain2 {

    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];

        // createOrder()를 여러번 사용해서 상품 주문 정보들을 생성하고 배열에 저장
        orders[0] = createOrder("사과", 1000,2);
        orders[1] = createOrder("배", 10040,22);
        orders[2] = createOrder("꿀", 10050,23);
        // printOrders()를 사용해서 상품 주문 정보 출력
        printOrders(orders);
        // getTotalAmount()를 사용해서 총 결제 금액 계산
        int totalAMount = getTotalAMount(orders);

        // 총 결제 금액 출력
        System.out.println("총 결제 금액 : " + totalAMount);
    }

    static void printOrders (ProductOrder[] orders) {

        for (ProductOrder po : orders) {
            System.out.println("상품명 : " +  po.productName + "금액 : " + po.price + "수량 : " + po.quantity);
        }
    }

     static ProductOrder createOrder(String productName, int price, int quantity){
        ProductOrder order =  new ProductOrder();
         order.productName = productName;
         order.price = price;
         order.quantity = quantity;
         return order;
    }

    static int getTotalAMount(ProductOrder[] order){

        int totalPrice = 0;
        for (ProductOrder po : order) {
            totalPrice =+ po.price * po.quantity;
        }

        return totalPrice;
    }
}
