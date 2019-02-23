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
    /// <summary>
    /// Lógica de interacción para RaceForm.xaml
    /// </summary>
    public partial class RaceForm : Window{

        private Race Race { get; set; }

        public RaceForm(Race race)
        {
            InitializeComponent();
            this.DataContext = this;

            Race = race;
            MyInitializeComponent();
        }

        private void MyInitializeComponent()
        {
            if (Race != null)
                txtName.Text = Race.Name;
        }

        private void BtnCancel_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void BtnAccept_Click(object sender, RoutedEventArgs e)
        {
            if (txtName.Text.Equals(""))
            {
                MessageBox.Show("Debe introducir un nombre", "Error");
                return;
            }

            if (Race == null)
                AddRace();
            else
                EditRace();
            
        }

        private void AddRace()
        {
            Race race = new Race(txtName.Text);
            if (!RepositoryImpl.GetInstance().AddRace(race))
                MessageBox.Show("La carrera ya existe", "Error");
            else
                this.Close();
        }

        private void EditRace()
        {
            Race race = new Race(txtName.Text);
            if (!RepositoryImpl.GetInstance().UpdateRace(Race, race))
                MessageBox.Show("La carrera ya existe", "Error");
            else
                this.Close();
        }
    }
}
