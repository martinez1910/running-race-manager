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
   public partial class RaceForm : Window{

       private Race Race { get; set; }
       private bool Modifying;
       private int Pos;
       private int Errors = 0;

       public RaceForm()
       {
           InitializeComponent();
           Race = new Race();
           this.DataContext = Race;
       }
       
       public RaceForm(Race race, int pos)
       {
           InitializeComponent();
           Race = race;
           this.DataContext = Race;
           Modifying = true;
           Pos = pos;
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

            if (!Modifying)
                AddRace();
            else
                EditRace();            
        }

        private void AddRace()
        {
            if (!RepositoryImpl.GetInstance().AddRace(Race))
                MessageBox.Show("La carrera ya existe", "Error");
            else
                this.Close();
        }

        private void EditRace()
        {
            if (!RepositoryImpl.GetInstance().UpdateRace(Race, Pos))
                MessageBox.Show("La carrera ya existe", "Error");
            else
                this.Close();
        }

        private void Validation_Error(object sender, ValidationErrorEventArgs args)
        {
            if (args.Action == ValidationErrorEventAction.Added)
                Errors++;
            else
                Errors--;

            if (Errors == 0)
                btnAccept.IsEnabled = true;
            else
                btnAccept.IsEnabled = false;
        }
    }
}
