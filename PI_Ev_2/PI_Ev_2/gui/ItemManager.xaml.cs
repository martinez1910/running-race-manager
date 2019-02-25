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
        private ObservableCollection<MyItem> _items;
        public ObservableCollection<MyItem> Items { get { return _items; } set { _items = value; } }

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

            MyItem item;
            try
            {
                item = (MyItem)DataGrid.SelectedItem;
            }
            catch (InvalidCastException)
            {
                return;
            }
            ItemForm window = new ItemForm((MyItem)item.Clone(), pos);
            window.ShowDialog();
        }

        private void BtnRemove_Click(object sender, RoutedEventArgs e)
        {
            if (DataGrid.SelectedCells.Count == 0)
            {
                MessageBox.Show("Seleccione un material", "Error");
                return;
            }

            MyItem item;
            try
            {
                item = (MyItem)DataGrid.SelectedCells[0].Item;
            }
            catch (InvalidCastException)
            {
                return;
            }
            if (!RepositoryImpl.GetInstance().RemoveItem(item))
                MessageBox.Show("El material está asociado a un avituallamiento", "Error");
        }
    }
}
