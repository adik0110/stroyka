package org.example;

public class Building implements StageInterface, BuildInterface {
    private LinkedList stages;
    private Node personThere;
    private Node nowStage;

    public Building() {
        stages = new LinkedList();
        stages.add(new ProjectStage());
        stages.add(new FoundationStage());
        stages.add(new WallStage());
        stages.add(new RoofStage());
        stages.add(new FinishingStage());
        nowStage = stages.root;
    }

    public Stage next() {
        if (personThere == null) {
            personThere = stages.root;
            return personThere.getStage();
        }
        if (personThere.next == null) {
            System.out.println("Дальше этапов уже нет");
            return null;
        }
        personThere = personThere.next;
        return personThere.getStage();
    }

    public Stage prev() {
        if (personThere == null || personThere.prev == null) {
            System.out.println("Там этапов нет");
            return null;
        }
        personThere = personThere.prev;
        return personThere.getStage();
    }

    public void start() {
        System.out.println("Стройка началась");
        ProgressOfBuilding();
    }

    private void ProgressOfBuilding() {
        if (stages.root.getStage().status == Status.DEFECT) {
            System.out.println("Стройка уже завершена неудачно");
            return;
        }
        if (nowStage.getStage().status == Status.COMPLETED) {
            System.out.println("Стройка уже завершена удачно");
            return;
        }
        nowStage.getStage().status = Status.PLANNED;
        System.out.println("Текущий этап - " + nowStage.getStage());
        try {
            nowStage.getStage().upgradeStatus();
            nowStage.getStage().upgradeStatus();
        } catch (DefectException e) {
            if (nowStage.getStage().name.equals("Проектирование") && nowStage.getStage().status == Status.DEFECT) {
                System.out.println("Жаль, но план забраковался");
                finish();
                while (nowStage.next != null) {
                    nowStage.getStage().status = Status.DEFECT;
                    nowStage = nowStage.next;
                }
                nowStage.getStage().status = Status.DEFECT;
                return;
            }
            System.out.println('\n' + "Этап забраковался" + '\n');
            ProgressOfBuilding();
            return;
        }
        if (nowStage.getStage().name.equals("Отделка") && nowStage.getStage().status == Status.COMPLETED) {
            finish();
            return;
        }

        System.out.println('\n' + "Переход на следующий этап..." + '\n');
        nowStage = nowStage.next;
        ProgressOfBuilding();
    }

    public void finish() {
        System.out.println("Стройка закончилась");
    }
}
