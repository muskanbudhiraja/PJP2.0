using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;

namespace DateTimeCalculator
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                Console.WriteLine("Select option \n1.enter date \n2.enter phrase \npress q to quit");
                var choice=Console.ReadLine();
                
                if (choice.Equals("1"))
                {
                    Console.WriteLine("Enter a date (e.g. dd/mm/yyyy)");
                    DateTime date = DateTime.Parse(Console.ReadLine());

                    Console.WriteLine("Options:\n1.add date \n2.subtract date \n3.determine day of week for given date" +
                        "\n4.determine week number for given date");
                    switch (Int32.Parse(Console.ReadLine()))
                    {
                        case 1:
                            Console.WriteLine(AddDate(date));
                            break;

                        case 2:
                            Console.WriteLine(SubtractDate(date));
                            break;

                        case 3:
                            Console.WriteLine(Operations.GetDayOfWeek(date));
                            break;

                        case 4:
                            break;

                        default:
                            break;
                    }
                    continue;
                }

                else if (choice.Equals("2"))
                {
                    string output = ProcessPhrases();
                    if (output != null)
                        Console.WriteLine(output);
                    else
                        Console.WriteLine("Cannot understand language");
                    continue;
                }
                else {
                    break;
                }
            }
        }
        static string AddDate(DateTime date)
        {
            Console.WriteLine("Enter n days/months/weeks \n e.g 4 days/ 2 months/ 3 weeks");
            string str = Console.ReadLine();
            var input = str.ToLower().Trim().Split();

            if (input[1].Contains("days") | input[1].Contains("day"))
                return Operations.AddDaysInDate(date, Int32.Parse(input[0]));

            else if (input[1].Contains("months") | input[1].Contains("month"))
                return Operations.AddMonthsInDate(date, Int32.Parse(input[0]));

            else if (input[1].Contains("weeks") | input[1].Contains("week"))
                return Operations.AddWeeksInDate(date, Int32.Parse(input[0]));

            return Operations.AddDaysInDate(date, Int32.Parse(input[0]));
        }

        static string SubtractDate(DateTime date)
        {
            Console.WriteLine("Enter n days/months/weeks \n e.g 4 days/ 2 months/ 3 weeks");
            string str = Console.ReadLine();
            var input = str.ToLower().Trim().Split();

            if (input[1].Contains("days") | input[1].Contains("day"))
                return Operations.SubtractDaysInDate(date, Int32.Parse(input[0]));

            else if (input[1].Contains("months") | input[1].Contains("month"))
                return Operations.SubtractMonthsInDate(date, Int32.Parse(input[0]));

            else if (input[1].Contains("weeks") | input[1].Contains("week"))
                return Operations.SubtractWeeksInDate(date, Int32.Parse(input[0]));

            return Operations.SubtractDaysInDate(date, Int32.Parse(input[0]));
        }

        static string ProcessPhrases() {

            NLP nlp = new NLP();
            Console.WriteLine("Enter phrase \n(e.g today , yesterday ,n days/months from now/earlier etc)");
            string phrase = Console.ReadLine().Trim().ToLower();

            if (nlp.SearchPhrase(phrase)!=null) {
                return nlp.SearchPhrase(phrase);
            }

            int days = Int32.Parse(Regex.Match(phrase,@"\d+").Value);
            DateTime today = DateTime.Today;



            if (phrase.Contains("from now"))
            {
                if (phrase.Contains("day") || phrase.Contains("days"))
                    return Operations.AddDaysInDate(today, days);
                else if (phrase.Contains("month") || phrase.Contains("months"))
                    return Operations.AddMonthsInDate(today, days);
                else if (phrase.Contains("year") || phrase.Contains("years"))
                    return Operations.AddYearsInDate(today, days);
            }

            else if (phrase.Contains("earlier"))
            {
                if (phrase.Contains("day") || phrase.Contains("days"))
                    return Operations.SubtractDaysInDate(today, days);
                else if (phrase.Contains("month") || phrase.Contains("months"))
                    return Operations.SubtractMonthsInDate(today, days);
                else if (phrase.Contains("year") || phrase.Contains("years"))
                    return Operations.SubtractYearsInDate(today, days);
            }

            return null;
        }
    }
}
