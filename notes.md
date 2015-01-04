# Can you trust your tests?

> QUIS CUSTODIET IPSOS CUSTODES? Who watches the watchmen?

Show of hands? Who does unit testing? Measure code coverage? TDD?

Code quality [like a boomerang] hits you back :)

How to measure test code quality and how to improve it.

Some things, like naming, test intent cannot be measured easily if at all

Test quality:
- readable
- focused
- concise
- well named
- etc

1. What is test quality
  a. prod vs test code quality
  b. coverage
    - line (add example and coverage report)
    - branch (add example and coverage report)
    - path (add example and coverage report)
    - data flow coverage (offtopic?)

Code coverage can show what is not tested, but not how good your tests are.
100 % code coverage for interpreted languages are like full compilation.

Mutation testing
A fault-based technique to assess and improve the quality of a test suite • Creates modified versions of the program 2 Mutation Testing Original Program Mutant
The number of killed mutants by a test suite as a measure of its effectiveness 3

Failing is a new passing
Mutation testing does not test your code - it tests your tests
Concept introduced in 1971 by Richard Lipton

what is mutation testing

Mutation Testing Techniques
Three aspects: • Mutation injection • Mutation types • Unit test selection per mutant •
Key properties: • Efficiency • Performance

Mutation Testing Challenges • High computational cost • Equivalent mutants – Syntactically different but semantically identical to the original program – 10 to 40 percent of mutants are equivalent 4

Show example of equal mutation.

static vs dynamic mutation

JDK frameworks: The tools differ mainly in the following respects:
• how the mutants are created (they can be brought to life by modifying source code or bytecode),
• the set of available mutators,
• performance (e.g. detecting equivalent mutations, so the tests are not run twice etc.).

PIT uses code coverage to decide which tests to run. Has incremental analysis (executes according to previous results or watches code base changes). Supports mocking.

Mutants are created by applying mutation operators - transformation rules to the production code.

killed/lived/timed out/out of memory/does not start (example of timed out)

Mutation Injection • Source code mutation • Binary code mutation • Caveats: • De-mutation • Compilation errors • Invalid binary code

Mutation Types • Some mutations never change behaviour • Constants reused by unit tests • Log messages • Some mutations can change behaviour • Switching between < and ≠ • Switching between < and ≤ • Some mutations always change behaviour • Switching between < and ≥

Mutation Types Guaranteed to Change Behaviour • Negation of the comparison • Switching between = and ≠ • Switching between < and ≥ • Switching between > and ≤ • Negation of boolean conditions • Adding a ¬, ! or ~ • Shortcutting boolean conditions • Replacement with True or False *

Other Problems • Recursion: • Stack overflows • Out of memory exceptions • Syntax errors • Segmentation faults

Mutation Testing Tools • Java: • PIT • Jester (Nester, Pester) • Jumble • Ruby: • Mutant • Heckle • C#: • NinjaTurtles

Mutant • Ruby 1.9 and 2.0 • rspec2 • Usually run from the command-line • Good to-the-point reporting • Good performance • OK documentation • Active project • https://github.com/mbj/mutant

Heckle • Ruby 1.8 • Doesn't work on Ruby 1.9 • Test::Unit and rSpec • Usually run from the command-line • Runs a set of unit tests on a class or a method • Good to-the-point reporting • Good performance • Virtually no documentation • http://rubyforge.org/projects/seattlerb/ • http://docs.seattlerb.org/heckle/

How to break the code:
- swap arithmetic operations
- swap comparison operator
- delete statements
- (code examples of mutations)

If the mutant survives:
- may need to write additional tests to kill it
- reduce what your code can do - refactor to a fully covered version
- remember TDD - write only the minimal amount of code to pass a test
(should add example of all cases)

How ruby does mutations (implementation details)

Shoud it be a part of your CI cycle?

Example on open source Ruby project.

Disadvantages
- are there good enough tools?
- exponential complexity - slow
- (parallel execution can be solution, if your tests can run concurrently)
Theory
- false negatives in rare cases - alternative implementation that pass your test
- it’s hard to develop a tool that can deal with all possible mutations


## Mutant
- only works with rspec (as of now), there's a branch for minitest
  support but no commits since April, 2014.

Mutant's supported mutation operators:

```
- and                - true and false
- and_asgn           - a &&= 1
- array              - [true]
- begin              - true; false
- block              - foo { a; b }
- block_pass         - foo(&bar)
- blockarg           - foo { |&bar| }
- boolean            - true
- break              - break true
- case               - case when true else end
- casgn              - A = true
- cbase              - ::A
- const              - A::B::C
- cvar               - @@a
- cvasgn             - @@a = true
- def                - def foo; end
- defined            - defined?(foo)
- dstr               - "foo#{bar}baz"
- dsym               - :"foo#{bar}baz"
- ensure             - begin; rescue; ensure; true; end
- false              - false
- float              - 10.0
- gvar               - $a
- gvasgn             - $a = true
- hash               - { true => true, false => false }
- if                 - if condition; true; else false; end
- int                - 10
- ivasgn             - @a = true
- kwbegin            - begin; true; end
- lvar               - a = nil; a
- lvasgn             - a = true
- masgn              - a, b = c, d
- match_current_line - true if /foo/
- next               - next true
- nil                - nil
- nthref             - $1
- op_assgn           - @a.b += 1
- or                 - true or false
- or_asgn            - a ||= 1
- range              - 1..100
- redo               - redo
- regex              - /foo/
- rescue             - begin; rescue ExA, ExB => error; true; end
- restarg            - foo(*bar)
- return             - return
- self               - self
- send               - a > b
- str                - "foo"
- super              - super
- symbol             - :foo
- true               - true
- until              - until true; foo; bar; end
- while              - while true; foo; bar; end
- yield              - yield true
```

to sum up:
- literal / primitive and compound
- statement deletion
- conditional
- binary connective replacment
- argument deletion / rename / swap
- unary operator exchange
- bitwise
- and more

What is what?
Subjects:  # Amount of subjects (methods) being mutated
Mutations: # Amount of mutations mutant generated
Kills:     # Amount of successfully killed mutations
Runtime:   # Total runtime
Killtime:  # Time spend killing mutations
Overhead:
Coverage:
Alive:


## How

Mutant uses a pure Ruby parser and an unparser to do its magic.

AST:

```
p Parser::CurrentRuby.parse("2 + 2")
# (send
#   (int 2) :+
#   (int 2))
```


## Test-Selection

Mutant uses the "longest rspec example group descriptions prefix match"
to select the tests to run.

For a subject like: Foo::Bar#baz
It will run example groups with description prefixes:

1. Foo::Bar#baz
2. Foo::Bar
3. Foo

Order is important. If mutant finds (1), won't run (2) and (3).


## Equivalent mutations

Original:

```
i = 0
while i != 10
  do_something
  i += 1
end
```

Mutant:

```
i = 0
while i < 10
  do_something
  i += 1
end
```


## Infinite Runtime

Original:

```
while expression
  do_something
end
```

Mutation:

```
while true
  do_something
end
```

## Coverage problem example

### Line

```
def foo(arg)
  arg ? "a" : "b"
end
```

```
expect(foo(true)).to eq "a"
```

100% line coverage. No test for "b".


### Branch/statement

```
def foo
  do_thing_ab
  do_thing_cd
end
```

```
expect(foo).to change { thing }.from(c).to(d)
```

This has 100% test coverage (line and branch/statement). No test for "thing ab".

## Reduction techniques
* Mutant sampling
* Mutant clustering
* more at http://www.iaria.org/conferences2012/filesICSEA12/Keynote-MutationTesting-jhassine.pdf