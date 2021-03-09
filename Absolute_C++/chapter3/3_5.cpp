#include <iostream>
using namespace std;

double totalCost(int numberParameter, double priceParameter);

int main()
{
    double price, bill;
    int number;

    cout << "Enter the number of items purchased: ";
    cin >> number;
    cout << "Enter the price per item $";
    cin >> price;

    bill = totalCost(number, price);

    cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout.precision(2);
    cout << number << " items at "
         << "$" << price << " each.\n"
         << "Final bill, including tax, is $" << bill
         << endl;

    return 0;
}

double totalCost(int numberParemeter, double priceParemeter)
{
    const double TAXRATE = 0.05;
    double subtotal;

    subtotal = priceParemeter * numberParemeter;
    return (subtotal + subtotal * TAXRATE);
}