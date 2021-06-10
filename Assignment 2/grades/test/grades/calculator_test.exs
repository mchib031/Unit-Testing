defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator

  describe "percentage_grade/0" do
    test "sample" do
      assert 85 ==
               Calculator.percentage_grade(%{
                 homework: [0.8],
                 labs: [1, 1, 1],
                 midterm: 0.70,
                 final: 0.9
               })
    end
  end

  describe "percentage_grade/1" do
    test "sample" do
      assert 50 ==
               Calculator.percentage_grade(%{
                 homework: [],
                 labs: [],
                 midterm: 1,
                 final: 1
               })
    end
  end

  describe "letter_grade/0" do
    test "sample" do
      assert "EIN" ==
               Calculator.letter_grade(%{
                 homework: [],
                 labs: [],
                 midterm: 0.39,
                 final: 0.39
               })
    end
  end

  describe "letter_grade/1" do
    test "sample" do
      assert "F" ==
             Calculator.letter_grade(%{
               homework: [0.41],
               labs: [0.26,0.26,0.26],
               midterm: 0.4,
               final: 0.4
             })
    end
  end

  describe "letter_grade/2" do
    test "sample" do
      assert "E" ==
           Calculator.letter_grade(%{
             homework: [0.4,0.4,0.4],
             labs: [0.4,0.4,0.4],
             midterm: 0.5,
             final: 0.5
           })
    end
  end

  describe "letter_grade/3" do
    test "sample" do
      assert "D" ==
         Calculator.letter_grade(%{
           homework: [0.5,0.5,0.5],
           labs: [0.5,0.5,0.5],
           midterm: 0.5,
           final: 0.5
           })
    end
  end

  describe "letter_grade/4" do
    test "sample" do
      assert "D+" ==
       Calculator.letter_grade(%{
         homework: [0.55,0.55,0.55],
         labs: [0.55,0.55,0.55],
         midterm: 0.55,
         final: 0.55
         })
     end
   end

  describe "letter_grade/5" do
    test "sample" do
      assert "C" ==
        Calculator.letter_grade(%{
          homework: [0.6,0.6,0.6],
          labs: [0.6,0.6,0.6],
          midterm: 0.6,
          final: 0.6
      })
    end
  end

  describe "letter_grade/6" do
    test "sample" do
      assert "C+" ==
        Calculator.letter_grade(%{
          homework: [0.65,0.65,0.65],
          labs: [0.65,0.65,0.65],
          midterm: 0.65,
          final: 0.65
      })
    end
  end

  describe "letter_grade/7" do
    test "sample" do
      assert "B" ==
        Calculator.letter_grade(%{
          homework: [0.7,0.7,0.7],
          labs: [0.7,0.7,0.7],
          midterm: 0.7,
          final: 0.7
      })
    end
  end

  describe "letter_grade/8" do
    test "sample" do
      assert "B+" ==
        Calculator.letter_grade(%{
          homework: [0.75,0.75,0.75],
          labs: [0.75,0.75,0.75],
          midterm: 0.75,
          final: 0.75
        })
      end
    end

    describe "letter_grade/9" do
      test "sample" do
        assert "A-" ==
          Calculator.letter_grade(%{
            homework: [0.8,0.8,0.8],
            labs: [0.8,0.8,0.8],
            midterm: 0.8,
            final: 0.8
          })
        end
      end

      describe "letter_grade/10" do
        test "sample" do
          assert "A" ==
            Calculator.letter_grade(%{
              homework: [0.85,0.85,0.85],
              labs: [0.85,0.85,0.85],
              midterm: 0.85,
              final: 0.85
            })
          end
        end

    describe "letter_grade/11" do
      test "sample" do
        assert "A+" ==
          Calculator.letter_grade(%{
            homework: [0.9,0.9,0.9],
            labs: [0.9,0.9,0.9],
            midterm: 0.9,
            final: 0.9
          })
        end
      end

      describe "numeric_grade/0" do
        test "sample" do
          assert "EIN" ==
                   Calculator.numeric_grade(%{
                     homework: [],
                     labs: [],
                     midterm: 0.39,
                     final: 0.39
                   })
        end
      end

      describe "numeric_grade/1" do
        test "sample" do
          assert 1 ==
                 Calculator.numeric_grade(%{
                   homework: [0.41],
                   labs: [0.26,0.26,0.26],
                   midterm: 0.4,
                   final: 0.4
                 })
        end
      end

      describe "numeric_grade/2" do
        test "sample" do
          assert 2 ==
               Calculator.numeric_grade(%{
                 homework: [0.4,0.4,0.4],
                 labs: [0.4,0.4,0.4],
                 midterm: 0.5,
                 final: 0.5
               })
        end
      end

      describe "numeric_grade/3" do
        test "sample" do
          assert 3 ==
             Calculator.numeric_grade(%{
               homework: [0.5,0.5,0.5],
               labs: [0.5,0.5,0.5],
               midterm: 0.5,
               final: 0.5
               })
        end
      end

      describe "numeric_grade/4" do
        test "sample" do
          assert 4 ==
           Calculator.numeric_grade(%{
             homework: [0.55,0.55,0.55],
             labs: [0.55,0.55,0.55],
             midterm: 0.55,
             final: 0.55
             })
         end
       end

      describe "numeric_grade/5" do
        test "sample" do
          assert 5 ==
            Calculator.numeric_grade(%{
              homework: [0.6,0.6,0.6],
              labs: [0.6,0.6,0.6],
              midterm: 0.6,
              final: 0.6
          })
        end
      end

      describe "numeric_grade/6" do
        test "sample" do
          assert 6 ==
            Calculator.numeric_grade(%{
              homework: [0.65,0.65,0.65],
              labs: [0.65,0.65,0.65],
              midterm: 0.65,
              final: 0.65
          })
        end
      end

      describe "numeric_grade/7" do
        test "sample" do
          assert 7 ==
            Calculator.numeric_grade(%{
              homework: [0.7,0.7,0.7],
              labs: [0.7,0.7,0.7],
              midterm: 0.7,
              final: 0.7
          })
        end
      end

      describe "numeric_grade/8" do
        test "sample" do
          assert 8 ==
            Calculator.numeric_grade(%{
              homework: [0.75,0.75,0.75],
              labs: [0.75,0.75,0.75],
              midterm: 0.75,
              final: 0.75
            })
          end
        end

        describe "numeric_grade/9" do
          test "sample" do
            assert 9 ==
              Calculator.numeric_grade(%{
                homework: [0.8,0.8,0.8],
                labs: [0.8,0.8,0.8],
                midterm: 0.8,
                final: 0.8
              })
            end
          end

          describe "numeric_grade/10" do
            test "sample" do
              assert 9 ==
                Calculator.numeric_grade(%{
                  homework: [0.85,0.85,0.85],
                  labs: [0.85,0.85,0.85],
                  midterm: 0.85,
                  final: 0.85
                })
              end
            end

        describe "numeric_grade/11" do
          test "sample" do
            assert 10 ==
              Calculator.numeric_grade(%{
                homework: [0.9,0.9,0.9],
                labs: [0.9,0.9,0.9],
                midterm: 0.9,
                final: 0.9
              })
            end
          end

end
