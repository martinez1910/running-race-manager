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
    public partial class RaceManager : Window
    {
        private ObservableCollection<Race> _races;
        public ObservableCollection<Race> Races{get{return _races;}}

        public RaceManager()
        {
            InitializeComponent();
            _races = RepositoryImpl.GetInstance().GetRaces();
            DataGrid.ItemsSource = Races;//Binding not working in XAML
        }

        private void BtnBack_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void BtnAdd_Click(object sender, RoutedEventArgs e)
        {
            RaceForm window = new RaceForm();
            window.ShowDialog();
        }

        private void BtnEdit_Click(object sender, RoutedEventArgs e)
        {
            int pos = DataGrid.SelectedIndex;
            if (pos == -1)
            {
                MessageBox.Show("Seleccione una carrera", "Error");
                return;
            }
            Race race = (Race) DataGrid.SelectedItem;
            RaceForm window = new RaceForm((Race)race.Clone(), pos);
            window.ShowDialog();
        }

        private void BtnRemove_Click(object sender, RoutedEventArgs e)
        {
            if (DataGrid.SelectedCells.Count == 0)
            {
                MessageBox.Show("Seleccione una carrera", "Error");
                return;
            }
            var race = (Race) DataGrid.SelectedCells[0].Item;
            RepositoryImpl.GetInstance().RemoveRace(race);
        }
    }
}
