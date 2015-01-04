# Loan Calculator


To run specs just do:
```
bundle exec rspec
```


To generate covarage report do:
```
COV=RAGE bundle exec rspec
```
and open coverage/index.html in your browser


To run mutations do:
```
bundle exec mutant -r ./loan.rb --use rspec "Loan*"
```
