using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PI_Ev_2.logic
{
    interface IRepository
    {
        ObservableCollection<Item> GetItems();
        bool AddItem(Item item);
        bool RemoveItem(Item item);
        bool UpdateItem(Item updatedItem, int pos);

        ObservableCollection<Supply> GetSupplies();
        bool AddSupply(Supply supply);
        bool RemoveSupply(Supply supply);
        bool UpdateSupply(Supply supply, Supply updatedSupply);

        ObservableCollection<Race> GetRaces();
        bool AddRace(Race race);
        bool RemoveRace(Race race);
        bool UpdateRace(Race updatedRace, int pos);
    }
}
