using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PI_Ev_2
{
    public class Item : INotifyPropertyChanged, ICloneable
    {
        private string _name;
        private string _type;
        private decimal _cost;

        public string Name { get { return _name; } set { _name = value; PropertyChanged(this, new PropertyChangedEventArgs("Nombre")); } }
        public string Type { get { return _type; } set { _type = value; PropertyChanged(this, new PropertyChangedEventArgs("Tipo")); } }
        public decimal Cost { get { return _cost; } set { _cost = value; PropertyChanged(this, new PropertyChangedEventArgs("Coste")); } }

        public Item()
        {
            _name = "";
            _type = "";
            _cost = 0;
        }
        public Item(string name, string type, decimal cost)
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
            var item = obj as Item;
            if (item == null)
                return false;
            return _name.Equals(item.Name) && _type.Equals(item._type) && _cost.Equals(item._cost);
        }

        public event PropertyChangedEventHandler PropertyChanged;

        public object Clone()
        {
            return this.MemberwiseClone();
        }
    }
}
