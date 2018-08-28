*This lab is based on the fine work of many individuals, this is simply a resource for updated versions and running solutions in a consisitant format.*

# lab-in-a-box v2
_Working implementations of each module in Docker._

### Currently supported modules:
  * ansible
    - multipe hosts and basic deployment playbook.
  * apache
  * go
  * haproxy
  * java
  * nginx
  * nodejs
  * php
  * python
  * reverse-proxy
  * tomcat
  * dropwizard

## Use guidelines:
*You may also find information by running  `make help`*

### All labs are Makefile based.

Update the master "agent.conf" and "agent-reverse-proxy.conf" (in root directory) with your lab site keys and any addtional configuration options you choose.  By default all labs will be mapped to http://localhost:4000. This can easily be overidden by running an EXPOSE_PORT value or changing the master Makefile with a desired port.

## General use: 

`make %module_of_choice%-build` 

example: `make php-build`
  -Builds lab for running
  
`make %module_of_choice%-build-no-cache` 

example: `make go-build-no-cache`
  -Builds lab without using any cached componets
  
`make %module_of_choice%-run` 

example: `make reverse-proxy-run`
  -Runs lab of choice (must run build first except ansible)
  
`make %module_of_choice%-clean` 

example:` make ansible-clean`
  -Removes running lab

`make %module_of_choice%-destory` 

example:` make ansible-destroy`
  -Removes running lab and all associated Docker images

## Load testing:
To loadtest your implementation use `make atrillery-build` and `make artillery-run`.  From the prompt use `loadtest -n 100000 -c 10 --rps 100 "http://localhost:4000`.  Edit the numbers to match your desired loadtest.
  
## Ansible use:
To run the Ansible lab use: 
`make ansible-run` or `make ansible-build` both have the same end result.  Once the nodes are alive, you'll be automatically dropped into master01 bash.  Initiate your connections using `ansible-playbook -i inventory ping_all.yml`.

Once all your nodes are responding and succesfully can ping, then you can run the SigSci installation playbook.  This playbook will install Apache (with module) and SigSci agent.  Run this by initialing `ansible-playbook -i inventory install_sigsci.yml`.  Once completed each of the servers in the "web" group will be loaded with Signal Sciences.  From master01 bash run `curl "http://host01?q=<script>alert()</script>"` to test.

## Credits - This lab was made possible by the following people:
* @Jack
* @Doug
* @Phillip
* @Imran
* @Micah
* And this fine [individual](https://github.com/LMtx/ansible-lab-docker.git) who wrote a killer Ansilbe lab.

