using PI_Ev_2.logic;
using System;
using System.Collections.Generic;
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
    public partial class SupplyFormItemForm : Window
    {
        private Supply _supply;

        public SupplyFormItemForm(Supply supply)
        {
            InitializeComponent();
            MyInitializeComponent();
            _supply = supply;
        }

        private void MyInitializeComponent()
        {
            foreach(Item item in RepositoryImpl.GetInstance().GetItems())
            {
                var cbi = new ComboBoxItem();
                cbi.Content = item;
                cbItems.Items.Add(cbi);
            }      
        }

        private void btnCancel_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void btnAdd_Click(object sender, RoutedEventArgs e)
        {
            var cbi = (ComboBoxItem)cbItems.SelectedItem;
            _supply.Items.Add((Item)cbi.Content);
            this.Close();
        }
    }
}
