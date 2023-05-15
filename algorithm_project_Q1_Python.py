#!/usr/bin/env python
# coding: utf-8

# In[4]:


#first we defined a function called schedule taking the jobs need to be sorted as parameters
def schedule(jobs):
# sort jobs by decreasing profit using lambda as akey for the sorting 
jobs = sorted(jobs, key=lambda x: x[2], reverse=True)
#initialize variables to 0 as we need to return them back at the end of the function
#and to keep the track in the order respectively

n_jobs = 0
max_profit = 0
schedule = [0] * max([job[1] for job in jobs])
# loop over jobs and schedule them if possible
# We initialize a schedule list with length equal to the maximum deadline among all jobs.
# We loop over each job and check if its deadline is available in the schedule.
# If it is available, we schedule the job and add its profit to the total profit.
    for job in jobs:
        deadline = job[1]
        if schedule[deadline-1] == 0:
            schedule[deadline-1] = job[0]

            n_jobs += 1
            max_profit += job[2]
    return n_jobs, max_profit

# example usage
jobs = [(1,4,20),(2,1,10),(3,1,40),(4,1,30)]
n_jobs, max_profit = schedule(jobs)
print("Number of jobs done:", n_jobs)
print("Maximum profit:", max_profit)


# In[ ]:




