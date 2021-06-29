defmodule Grades.Calculator do

# Question 2.1
  def avg(homework, labs) do 
    avg_homework =
      if Enum.count(homework) == 0 do
        0
      else
        Enum.sum(homework) / Enum.count(homework)
    end

    avg_labs =
      if Enum.count(labs) == 0 do
        0
      else
        Enum.sum(labs) / Enum.count(labs)
    end
    {avg_homework, avg_labs}
  end

# Question 2.2
  def failed_to_participate(avg_homework, avg_exams, num_labs) do 
    avg_homework < 0.4 || avg_exams < 0.4 || num_labs < 3
  end

# Question 2.3
  def calculate_grade(avg_labs, avg_homework, midterm, final) do 
    0.2 * avg_labs + 0.3 * avg_homework + 0.2 * midterm + 0.3 * final
  end

# Question 2.4.1
def letter(mark)do
cond do
        mark > 0.895 -> "A+"
        mark > 0.845 -> "A"
        mark > 0.795 -> "A-"
        mark > 0.745 -> "B+"
        mark > 0.695 -> "B"
        mark > 0.645 -> "C+"
        mark > 0.595 -> "C"
        mark > 0.545 -> "D+"
        mark > 0.495 -> "D"
        mark > 0.395 -> "E"
        :else -> "F"
      end
end
  

# Question 2.4.2
  def number(mark) do
  cond do
        mark > 0.895 -> 10
        mark > 0.845 -> 9
        mark > 0.795 -> 8
        mark > 0.745 -> 7
        mark > 0.695 -> 6
        mark > 0.645 -> 5
        mark > 0.595 -> 4
        mark > 0.545 -> 3
        mark > 0.495 -> 2
        mark > 0.395 -> 1
        :else -> 0
      end
  end

  def percentage_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
  
    {avg_homework, avg_labs} = avg(homework, labs)#question 2.1

    mark = calculate_grade(avg_labs, avg_homework, midterm, final)#question 2.3
    round(mark * 100)
  end


  def letter_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    {avg_homework, avg_labs} = avg(homework, labs)

     avg_exams = (midterm + final) / 2

    num_labs =
      labs
      |> Enum.reject(fn mark -> mark < 0.25 end)
      |> Enum.count()

    if failed_to_participate(avg_homework, avg_exams, num_labs) do #question 2.2
      "EIN"
    else
      mark = calculate_grade(avg_labs, avg_homework, midterm, final) #question 2.3

      letter(mark)
      
    end
  end

  def numeric_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    
    {avg_homework, avg_labs} = avg(homework, labs)

     avg_exams = (midterm + final) / 2

    num_labs =
      labs
      |> Enum.reject(fn mark -> mark < 0.25 end)
      |> Enum.count()

    if failed_to_participate(avg_homework, avg_exams, num_labs) do #question 2.2
      0
    else
      mark = calculate_grade(avg_labs, avg_homework, midterm, final) #question 2.3

      number(mark)
    end
  end


end