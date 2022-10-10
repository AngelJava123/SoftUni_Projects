const { expect, assert } = require('chai')
const PaymentPackage = require('../16. Payment Package')

describe("PaymentPackage", () => {
    describe("create instance", () => {
        let paymentPackage;
        beforeEach(() => {
            paymentPackage = new PaymentPackage("Angel", 10);
        });
        it("name should be correct", () => {
            assert.equal(paymentPackage._name, "Angel", "name is correct set to Angel");
        });
        it("value should be correct", () => {
            assert.equal(paymentPackage._value, 10, "value is correct set to 10")
        });
        it("vat should be correct value", () => {
            assert.equal(paymentPackage._VAT, 20, "default value is set correct");
            assert.equal(typeof (paymentPackage._VAT), "number", "vat is correct type")
        });
        it("active should be correct", () => {
            assert.equal(paymentPackage._active, true, "active has correct initial value true")
            assert.equal(typeof (paymentPackage._active), "boolean", "active has correct type")
        })
    })
    describe("test getters", () => {
        let paymentPackage;
        beforeEach(() => {
            paymentPackage = new PaymentPackage("Angel", 10);
        });
        it("instance should be returning correct name", () => {
            assert.equal(paymentPackage.name, "Angel");
        });
        it("should be return correct value", () => {
            assert.equal(paymentPackage.value, 10);
        });
        it("test vat value", () => {
            assert.equal(paymentPackage.VAT, 20);
        });
        it("test active", () => {
            assert.equal(paymentPackage.active, true);
        });
    });
    describe("Test setters", () => {
        let paymentPackage;
        beforeEach(() => {
            paymentPackage = new PaymentPackage("Angel", 10);
        });
        it("set correct type for name", () => {
            assert.Throw(() => new PaymentPackage(10, 10), "Name must be a non-empty string")
        })
        it("set empty name", () => {
            assert.throw(() => new PaymentPackage("", 10), "Name must be a non-empty string")
        })
        it("set correct name", () => {
            assert.equal(paymentPackage.name, "Angel");
            paymentPackage.name = "George"
            assert.equal(paymentPackage.name, "George")
        })
        it("set incorrect value type", () => {
            assert.throw(() => new PaymentPackage("Angel", "10"), "Value must be a non-negative number")
        })
        it("set negative value", () => {
            assert.throw(() => new PaymentPackage("Angel", -50), "Value must be a non-negative number")
        })
        it("set correct value", () => {
            assert.equal(paymentPackage.value, 10);
            paymentPackage.value = 50;
            assert.equal(paymentPackage.value, 50);
            paymentPackage.value = 0;
            assert.equal(paymentPackage.value, 0)
        });
        it("set incorrect VAT type", () => {
            assert.throw(() => paymentPackage.VAT = "George", "VAT must be a non-negative number")
        })
        it("set incorrect VAT value", () => {
            assert.throw(() => paymentPackage.VAT = -100, "VAT must be a non-negative number")
        })
        it("set correct VAT value", () => {
            assert.equal(paymentPackage.VAT, 20);
            paymentPackage.VAT = 30;
            assert.equal(paymentPackage.VAT, 30)
        })
        it("set incorrect active status value", () => {
            assert.Throw(() => paymentPackage.active = "George", "Active status must be a boolean")
        })
        it("set correct value", () => {
            assert.equal(paymentPackage.active, true);
            paymentPackage.active = false;
            assert.equal(paymentPackage.active, false)
        })
    })
    describe("toString", () => {
        let paymentPackage;
        beforeEach(() => {
            paymentPackage = new PaymentPackage("Angel", 10);
        });
        it("test active state", () => {
            const output = [
                `Package: Angel`,
                `- Value (excl. VAT): 10`,
                `- Value (VAT 20%): ${10 * (1 + 20 / 100)}`
            ].join("\n")
            assert.equal(paymentPackage.toString(), output)
        })
        it("test not active state", () => {
            const output = [
                `Package: Angel (inactive)`,
                `- Value (excl. VAT): 10`,
                `- Value (VAT 20%): ${10 * (1 + 20 / 100)}`
            ].join("\n")
            paymentPackage.active = false;
            assert.equal(paymentPackage.toString(), output)
        })
    })
})