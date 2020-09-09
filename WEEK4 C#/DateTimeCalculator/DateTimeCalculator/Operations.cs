using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace DateTimeCalculator
{
    class Operations
    {
        
        public static string AddDaysInDate(DateTime date, int numberOfDaysToBeAdded)
        {
            return new DateTime(date.Ticks).AddDays(numberOfDaysToBeAdded).ToShortDateString();
        }

        public static string AddWeeksInDate(DateTime date,int numberOfWeeksToBeAdded)
        {
            return new DateTime(date.Ticks).AddDays(7*numberOfWeeksToBeAdded).ToShortDateString();
        }

        public static string AddMonthsInDate(DateTime date,int numberOfMonthsToBeAdded)
        {
            return new DateTime(date.Ticks).AddMonths(numberOfMonthsToBeAdded).ToShortDateString();
        }

        public static string AddYearsInDate(DateTime date, int numberOfYearsToBeAdded)
        {
            return AddMonthsInDate(date,12*numberOfYearsToBeAdded);
        }

        public static string GetDayOfWeek(DateTime date) {
            return new DateTime(date.Ticks).DayOfWeek.ToString();
        }

       
        public static void GetWeekNumber(DateTime date)
        {
            //pending
        }

       

        public static string SubtractWeeksInDate(DateTime date, int numberOfWeeksToBeSubtracted)
        {
            return new DateTime(date.Ticks).AddDays((-7)* numberOfWeeksToBeSubtracted).ToShortDateString();
        }

        public static string SubtractMonthsInDate(DateTime date, int numberOfMonthsToBeSubtracted)
        {
            return new DateTime(date.Ticks).AddMonths((-1) * numberOfMonthsToBeSubtracted).ToShortDateString();
        }

        public static string SubtractDaysInDate(DateTime date, int numberOfDaysToBeSubtracted)
        {
            return new DateTime(date.Ticks).AddDays((-1)* numberOfDaysToBeSubtracted).ToShortDateString();
        }

        public static string SubtractYearsInDate(DateTime today, int numberOfYearsToBeSubtracted)
        {
            return SubtractMonthsInDate(today, 12 * numberOfYearsToBeSubtracted);
        }

    }
}
