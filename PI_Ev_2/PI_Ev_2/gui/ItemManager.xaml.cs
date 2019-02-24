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
    public partial class ItemManager : Window
    {
        private ObservableCollection<Item> _items;
        public ObservableCollection<Item> Items { get { return _items; } set { _items = value; } }

        public ItemManager()
        {
            InitializeComponent();
            _items = RepositoryImpl.GetInstance().GetItems();
            DataGrid.ItemsSource = _items;
        }


        private void BtnBack_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void BtnAdd_Click(object sender, RoutedEventArgs e)
        {
            ItemForm window = new ItemForm();
            window.ShowDialog();
        }

        private void BtnEdit_Click(object sender, RoutedEventArgs e)
        {
            int pos = DataGrid.SelectedIndex;
            if (pos == -1)
            {
                MessageBox.Show("Seleccione un material", "Error");
                return;
            }
            Item item = (Item)DataGrid.SelectedItem;
            ItemForm window = new ItemForm((Item)item.Clone(), pos);
            window.ShowDialog();
        }

        private void BtnRemove_Click(object sender, RoutedEventArgs e)
        {
            if (DataGrid.SelectedCells.Count == 0)
            {
                MessageBox.Show("Seleccione una carrera", "Error");
                return;
            }
            var item = (Item)DataGrid.SelectedCells[0].Item;
            RepositoryImpl.GetInstance().RemoveItem(item);
        }
    }
}
