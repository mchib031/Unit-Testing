defmodule Grades.Calculator do
""" 
on genera un nombre random entre 0 a 100 pour la méthode de calcule de grade avec pourcentage
"""
  def percentage_grade(mark) do
  Enum.random(0..100)
  end

""" 
on genera un nombre random de A+ a EIN pour la méthode de calcule de grade avec letter grade
"""
  def letter_grade(mark) do 
  Enum.random(["A+","A","A-","B+","B","C+","C","D+","D","E","F","EIN"])
  end
""" 
on genera un nombre random entre 1 a 10 pour la méthode de calcule de grade avec numeric grade 
"""
  def numeric_grade(mark) do
  Enum.random(1..10)
  end
end
