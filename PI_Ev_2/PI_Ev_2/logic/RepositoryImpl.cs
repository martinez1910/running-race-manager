using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PI_Ev_2.logic
{
    class RepositoryImpl : IRepository
    {
        private static RepositoryImpl Instance = null;
        private ObservableCollection<Race> Races;
        private ObservableCollection<Supply> Supplies;
        private ObservableCollection<Item> Items;

        private RepositoryImpl()
        {
            Races = new ObservableCollection<Race>();
            Supplies = new ObservableCollection<Supply>();
            Items = new ObservableCollection<Item>();
        }

        public static RepositoryImpl GetInstance()
        {
            if (Instance == null)
                Instance = new RepositoryImpl();
            return Instance;
        }


        public ObservableCollection<Item> GetItems()
        {
            return Items;
        }
        public bool AddItem(Item item)
        {
            if(Items.Contains(item))
                return false;
            Items.Add(item);
            return true;
        }
        public bool RemoveItem(Item item)
        {
            foreach (Supply supply in Supplies)
                if (supply.Items.Contains(item))
                    return false;
            return Items.Remove(item);
        }
        public bool UpdateItem(Item updatedItem, int pos)
        {
            if (Items.Contains(updatedItem))
                return false;
            Items[pos] = updatedItem;
            return true;
        }


        public ObservableCollection<Supply> GetSupplies()
        {
            return Supplies;
        }
        public bool AddSupply(Supply supply)
        {
            if (Supplies.Contains(supply))
                return false;
            Supplies.Add(supply);
            return true;
        }
        public bool RemoveSupply(Supply supply)
        {
            return Supplies.Remove(supply);
        }
        public bool UpdateSupply(Supply updatedSupply, int pos)
        {
            if (Supplies.Contains(updatedSupply))
                return false;
            Supplies[pos] = updatedSupply;
            return true;
        }


        public ObservableCollection<Race> GetRaces()
        {
            return Races;
        }
        public bool AddRace(Race race)
        {
            if (Races.Contains(race))
                return false;
            Races.Add(race);
            return true;
        }
        public bool RemoveRace(Race race)
        {
            bool result = true;
            foreach(Supply supply in Supplies)
                if(supply.Race.Equals(race))
                    result = result && Supplies.Remove(supply);

            return result && Races.Remove(race);
        }
        public bool UpdateRace(Race updatedRace, int pos)
        {
            if (Races.Contains(updatedRace))
                return false;
            Races[pos] = updatedRace;
            return true;
        }    
    }
}
