# Magneto headhunting

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.


## Prerrequisitos

```
Java 8
Maven
Lombok
```
## Endpoints

POST  /mutant/ <br/>
{<br />
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]<br/>
}<br/><br/>
GET  /stats/ <br/>
{<br/>
    "ratio": 0.5,<br/>
    "count_mutant_dna": 1,<br/>
    "count_human_dna": 2<br/>
}