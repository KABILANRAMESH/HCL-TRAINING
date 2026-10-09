\# Day 5 UML Sketch



```text

&#x20;                 <<abstract>>

&#x20;                   Payment

&#x20;               + pay()

&#x20;               + pay(reference)

&#x20;               + processPayment()

&#x20;                      |

&#x20;         +------------+------------+

&#x20;         |            |            |

&#x20;    CardPayment   UPIPayment   CashPayment

&#x20;         |            |

&#x20;         +----- implements -----+

&#x20;                   Refundable

&#x20;                  + refund(amount)





&#x20;            <<interface>>

&#x20;            PaymentStrategy

&#x20;         + calculateAmount(baseAmount)

&#x20;         + getStrategyName()

&#x20;                   ^

&#x20;                   |

&#x20;         +---------+----------+

&#x20;         |                    |

&#x20;StandardPaymentStrategy  DiscountPaymentStrategy





&#x20;                 <<abstract>>

&#x20;                HospitalStaff

&#x20;              + getRole()

&#x20;              + displayDetails()

&#x20;                      ^

&#x20;                      |

&#x20;            +---------+----------+

&#x20;            |                    |

&#x20;          Doctor             Receptionist





&#x20;                 <<abstract>>

&#x20;                 BaseEntity

&#x20;              + getEntityType()

&#x20;                      ^

&#x20;                      |

&#x20;                   Patient

</text>

