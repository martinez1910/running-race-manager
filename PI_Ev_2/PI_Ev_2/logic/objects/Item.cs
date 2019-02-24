using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PI_Ev_2
{
    public class MyItem : INotifyPropertyChanged, ICloneable, IDataErrorInfo
    {
        private string _name;
        private string _type;
        private decimal _cost;

        public string Name { get { return _name; } set { _name = value; PropertyChanged(this, new PropertyChangedEventArgs("Name")); } }
        public string Type { get { return _type; } set { _type = value; PropertyChanged(this, new PropertyChangedEventArgs("Type")); } }
        public decimal Cost { get { return _cost; } set { _cost = value; PropertyChanged(this, new PropertyChangedEventArgs("Cost")); } }

        public MyItem()
        {
            _name = "";
            _type = "";
            _cost = 0;
        }
        public MyItem(string name, string type, decimal cost)
        {
            _name = name;
            _type = type;
            _cost = cost;
        }


        public override string ToString()
        {
            return _name + " - " + _type + " - " + _cost;
        }
        public override bool Equals(object obj)
        {
            var item = obj as MyItem;
            if (item == null)
                return false;
            return _name.Equals(item.Name) && _type.Equals(item._type) && _cost.Equals(item._cost);
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

        public string this[string columnName] //Compiler Error CS0542 if class named Item
        {
            get
            {
                if (columnName.Equals("Name"))
                    if (string.IsNullOrEmpty(_name))
                        return "Debe introducir un nombre";
                if (columnName.Equals("Type"))
                    if (string.IsNullOrEmpty(_type))
                        return "Debe seleccionar un tipo de material";
                if (columnName.Equals("Cost"))
                    if (_cost < 0)
                        return "Debe introducir un precio válido";

                return "";
            }            
        }
    }
}
