# banana-pay
A simple Point-of-sale (POS) API 

## Structure

### Terminal
```
Terminal terminal = new Terminal();
terminal.addItem("A", 4.57);        // $4.57 for single item
terminal.setDeal("A", 4, 15.00);    // $15.00 for every 4
terminal.addItem("B", 10.00);       // $10.00 for single item, no sale/bulk price

// Ring up a customer with AAAABBB
terminal.clearCart();   // Just to be safe
terminal.scan("A", 4);
termianl.scan("B", 3);
terminal.printTotal();  // Total: $45.00

// Whoops! Customer only wanted 2 B's
terminal.voidItem("B");
terminal.printTotal();  // Total: $35.00
```

### Item
```
Item a = new Item("A", 4.57);
a.getName();                // "A"
a.getBasePrice();           // 4.57
a.getTotalCost(2);          // 9.14
a.getTotalCost(10);         // 45.70
a.getVolumeQuantity();      // 2147483647 (default to make modulus arithmetic work)
a.getVolumeCost();          // 0
a.setVolumePrice(4, 15.00);
a.getTotalCost(10);         // 39.14
```

## Improvements

- allow different kinds of deals 
    - bulk price w/o modulus (buy 4+, get each for $3)
    - buy one, get one free/half off or similar
    - coupon scan (% off an item, $ off an item) --> Coupon class
- allow payments and receipts (cash, credit, debit, gift cards)
- refactor for MVC
    - ("M") Item should only have `name` and `basePrice`
    - ("V") Terminal should only have standard methods
        - `scanItem`
        - `voidItem`
        - `getItemPrice`
        - `scanCoupon`
        - `applyDiscount`
        - `printTotal`
        - `clearCart`
        - `updateTotal`
    - ("C") Maintains items, coupons, and several deal types associated with items.
        - `addItem`
        - `setDeal`
        - `clearItems`
