class Loan
  def initialize(income, kids = 0)
    @income = income
    @kids   = kids
  end

  def offer
    if @income < 4000 || @kids > 0
      @income * 20
    else
      @income * 10
    end
  end
end
