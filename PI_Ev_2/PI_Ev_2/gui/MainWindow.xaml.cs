using PI_Ev_2.gui;
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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace PI_Ev_2
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void BtnRaceManager_Click(object sender, RoutedEventArgs e)
        {
            RaceManager window = new RaceManager();
            window.ShowDialog();
        }

        private void BtnSupplyManager_Click(object sender, RoutedEventArgs e)
        {
            SupplyManager window = new SupplyManager();
            window.ShowDialog();
        }

        private void BtnItemsManager_Click(object sender, RoutedEventArgs e)
        {
            ItemManager window = new ItemManager();
            window.ShowDialog();
        }
        
        private void BtnExit_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        
    }
}
