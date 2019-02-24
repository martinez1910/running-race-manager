using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PI_Ev_2
{
    public class Race : INotifyPropertyChanged, ICloneable, IDataErrorInfo
    {
        private string _name;
        public string Name
        {
            get { return _name; } 
            set 
            {
                _name = value;
                PropertyChanged(this, new PropertyChangedEventArgs("Name"));
            }
        }

        public Race()
        {
            _name = "";
        }
        public Race(string name)
        {
            _name = name;
        }

        public override string ToString()
        {
            return _name;
        }

        public override bool Equals(object obj)
        {
            var item = obj as Race;
            if (item == null)
                return false;
            return this._name.Equals(item.Name);
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
                String result = "";
                if(columnName.Equals("Name"))
                    if(string.IsNullOrEmpty(_name))
                        result = "Debe introducir un nombre";

                return result;
            }
        }
    }
}
