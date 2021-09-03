import java.util.ArrayList;
import java.util.List;

/**
 *
 * * /
 *  *      /子部门1
 *  *          /叶子部门1
 *  *          /叶子部门2
 *  *      /子部门2
 *  *          /叶子部门3
 *
 */
public class DepartmentTest {
    public static void main(String[] args) {
        Department coreDep = new Department("主部门");

        Department dep1 = new Department("子部门1");
        Department dep2 = new Department("子部门2");

        coreDep.child.add(dep1);
        coreDep.child.add(dep2);

        Department leaf1 = new Department("叶子部门1");
        Department leaf2 = new Department("叶子部门2");
        Department leaf3 = new Department("叶子部门3");

        dep1.child.add(leaf1);
        dep1.child.add(leaf2);
        dep2.child.add(leaf3);



    }
    public static class Department{
        private String name;
        private List<Department> child=new ArrayList<Department>();

        public List<Department> getChild() {
            return child;
        }

        public void setChild(List<Department> child) {
            this.child = child;
        }

        public Department(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
