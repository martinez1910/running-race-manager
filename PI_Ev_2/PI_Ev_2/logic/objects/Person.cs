using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PI_Ev_2
{
    public class Person : INotifyPropertyChanged, ICloneable, IDataErrorInfo
    {
        private string _name;
        private string _phone;

        public string Name { get { return _name; } set { _name = value; PropertyChanged(this, new PropertyChangedEventArgs("Name")); } }
        public string Phone { get { return _phone; } set { _phone = value; PropertyChanged(this, new PropertyChangedEventArgs("Phone")); } }

        public Person()
        {
            _name = "";
            _phone = "";
        }
        public Person(string name, string phone)
        {
            _name = name;
            _phone = phone;
        }

        public override string ToString()
        {
            return "Person: " + Name + " " + Phone;
        }

        public event PropertyChangedEventHandler PropertyChanged;

        public object Clone()
        {
            return this.MemberwiseClone();
        }

        public string Error
        {
            get { return ""; }
        }

        public string this[string columnName]
        {
            get
            {
                if (columnName.Equals("Name"))
                    if (string.IsNullOrEmpty(_name))
                        return "Debe introducir un nombre";
                if (columnName.Equals("Phone"))
                    if (string.IsNullOrEmpty(_phone))
                        return "Debe introducir un número de teléfono";

                return "";
            }
        }
    }
}
