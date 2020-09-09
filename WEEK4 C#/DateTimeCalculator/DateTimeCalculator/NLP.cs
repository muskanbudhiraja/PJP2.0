using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DateTimeCalculator
{
    class NLP
    {
        private Dictionary<string, string> phrases;

        public NLP()
        {
            phrases = new Dictionary<string, string>();
            InitMap();
        }

        private void InitMap()
        {
            DateTime today = DateTime.Today;
            phrases.Add("today", today.ToShortDateString());
            phrases.Add("tomorrow", Operations.AddDaysInDate(today,1));
            phrases.Add("yesterday",Operations.SubtractDaysInDate(today,1));
            phrases.Add("last week",Operations.SubtractWeeksInDate(today,1));
            phrases.Add("previous week",phrases["last week"]);
            phrases.Add("next week",Operations.AddWeeksInDate(today,1));
            phrases.Add("last month",Operations.SubtractMonthsInDate(today,1));
            phrases.Add("next month", Operations.AddMonthsInDate(today, 1));
            phrases.Add("last year",Operations.SubtractYearsInDate(today,1));
            phrases.Add("next year",Operations.AddYearsInDate(today,1));
            phrases.Add("month after",phrases["next month"]);
            phrases.Add("month before",phrases["last month"]);
            phrases.Add("day after tomorrow", Operations.AddDaysInDate(today, 2));
            phrases.Add("day before yesterday", Operations.SubtractDaysInDate(today, 2));

        }

        public string SearchPhrase(string phrase) {
            if (phrases.ContainsKey(phrase))
                return phrases[phrase];
            return null;
        }
       
    }
}
