using PI_Ev_2.logic;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace PI_Ev_2.gui
{
    public partial class SupplyManager : Window
    {
        
        private ObservableCollection<Supply> _supplies;
        public ObservableCollection<Supply> Supplies{get{return _supplies;}}


        public SupplyManager()
        {
            InitializeComponent();
            _supplies = RepositoryImpl.GetInstance().GetSupplies();
            DataGrid.ItemsSource = Supplies;
        }

        private void BtnBack_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void BtnAdd_Click(object sender, RoutedEventArgs e)
        {
            SupplyForm window = new SupplyForm();
            window.ShowDialog();
        }

        private void BtnEdit_Click(object sender, RoutedEventArgs e)
        {
            int pos = DataGrid.SelectedIndex;
            if (pos == -1)
            {
                MessageBox.Show("Seleccione un avituallamiento", "Error");
                return;
            }
            Supply supply;
            try
            {
                supply = (Supply)DataGrid.SelectedItem;
            }
            catch (InvalidCastException)
            {
                return;
            }
            SupplyForm window = new SupplyForm(supply.DeepClone(), pos);
            window.ShowDialog();
        }

        private void BtnRemove_Click(object sender, RoutedEventArgs e)
        {
            if (DataGrid.SelectedCells.Count == 0)
            {
                MessageBox.Show("Seleccione un avituallamiento", "Error");
                return;
            }

            Supply supply;
            try
            {
                supply = (Supply)DataGrid.SelectedCells[0].Item;
            }
            catch (InvalidCastException)
            {
                return;
            }
            RepositoryImpl.GetInstance().RemoveSupply(supply);
        }
    }
}
