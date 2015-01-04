if ENV["COV"]
  require 'simplecov'
  SimpleCov.start
end

require_relative "../loan"

RSpec.describe Loan do
  # context "argument guards" do
  #   it "raises an ArgumentError if non-numeric income is provided" do
  #     expect { Loan.new("none") }.to raise_error(ArgumentError)
  #   end

  #   it "raises an ArgumentError if negative income is provided" do
  #     expect { Loan.new(-1) }.to raise_error(ArgumentError)
  #   end

  #   # it "raises an ArgumentError if negative kids are provided" do
  #   #   expect { Loan.new(1, -1) }.to raise_error(ArgumentError)
  #   # end
  # end

  # context "when income is 4000 or more" do
  #   it "gives 10x if the income is 4000" do
  #     expect(Loan.new(4000).offer).to eq 40_000
  #   end

  #   it "gives 10x the monthly income by default" do
  #     expect(Loan.new(5000).offer).to eq 50_000
  #   end

  #   # context "when has kids" do
  #   #   it "gives 20x" do
  #   #     expect(Loan.new(4500, 1).offer).to eq 90_000
  #   #   end
  #   # end
  # end

  # context "when income is less than 4000" do
  #   it "gives 20x" do
  #     expect(Loan.new(3999).offer).to eq 79_980
  #   end

  #   it "gives 0 if no income" do
  #     expect(Loan.new(0).offer).to eq 0
  #   end
  # end
end
