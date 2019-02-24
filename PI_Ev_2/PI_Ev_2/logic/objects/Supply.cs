using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PI_Ev_2
{
    public class Supply : INotifyPropertyChanged, ICloneable, IDataErrorInfo
    {
        private byte _kilometricPoint;

        public Race Race { get; set; }
        public byte KilometricPoint { 
            get{return _kilometricPoint;}
            set { _kilometricPoint = value; PropertyChanged(this, new PropertyChangedEventArgs("KilometricPoint")); } 
        }
        public Person Person { get; set; }
        public ObservableCollection<MyItem> Items { get; set; }

        public Supply()
        {
            Race = new Race();
            _kilometricPoint = 0;
            Person = new Person();
            Items = new ObservableCollection<MyItem>();
        }

        public Supply(Race race, byte kilometricPoint, Person person, ObservableCollection<MyItem> items)
        {
            Race = race;
            _kilometricPoint = kilometricPoint;
            Person = person;
            Items = items;
        }

        public override bool Equals(object obj)
        {
            var item = obj as Supply;
            if (item == null)
                return false;
            return Race.Equals(item.Race) && KilometricPoint.Equals(item.KilometricPoint)
                && Person.Equals(item.Person) && Items.Equals(item.Items);
        }
    
        public event PropertyChangedEventHandler PropertyChanged;

        public object Clone()
        {
            return this.MemberwiseClone();
        }

        public Supply DeepClone()
        {
            var supply = (Supply)Clone();
            var newItems = new ObservableCollection<MyItem>();
            foreach (MyItem item in Items)
                newItems.Add((MyItem)item.Clone());
            supply.Items = newItems;

            var newRace = (Race)Race.Clone();
            supply.Race = newRace;

            return supply;
        }

        public string Error
        {
            get { return ""; }
        }

        public string this[string columnName]
        {
            get { return ""; }
        }
    }
}
