# Leetcode
Summary of thought in some questions.


SQL:
find the second highest salary in Employee:
select
IFNULL(
 (select distinct Salary from Employee 
order by Salary desc
limit 1 offset 1),
null) as SecondHighestSalary
