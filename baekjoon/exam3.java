package baekjoon;

import java.util.StringTokenizer;

public class exam3 {
    public static void main(String[] args) {
        String program = "line";
        String[] flag_rules = { "-s STRING", "-num NUMBER", "-e NULL", "-n ALIAS -num" };
        String[] commands = { "line -n 100 -s hi -e", "line -n 100 -e -num 150" };
        boolean[] answer = solution(program, flag_rules, commands);
        System.out.println(answer);
    }

    static boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = {};
        boolean[] test = new boolean[commands.length];
        StringTokenizer st;
        String program_name;// 프로그램 이름 판별
        String[] tags = new String[flag_rules.length];
        String[] tags_type = new String[flag_rules.length];
        String[] alias_tags = new String[flag_rules.length];
        String commands_tags = "";
        char[] commands_tags_seperator;
        char[] commands_seperater;
        String program_commands = "";
        String commands_name = "";
        boolean tags_flags = false;

        for (int i = 0; i < flag_rules.length; i++) {
            st = new StringTokenizer(flag_rules[i]);
            tags[i] = st.nextToken();
            tags_type[i] = st.nextToken();
            if (tags_type[i].equals("ALIAS")) {
                alias_tags[i] = st.nextToken();
            }
        }

        for (int i = 0; i < commands.length; i++) {
            test[i] = true;
            st = new StringTokenizer(commands[i]);
            program_name = st.nextToken();
            if (!(program.equals(program_name)) || !(program.length() >= 1 && program.length() <= 10)) {
                test[i] = false;///////// 수정
                break;
            }
            do {
                if (!tags_flags) {
                    commands_tags = st.nextToken();
                }
                commands_tags_seperator = commands_tags.toCharArray();
                if (tags_flags == true || commands_tags_seperator[0] == '-') {//////////////////////////// commands맞는
                                                                              //////////////////////////// 태그를 찾아서 자료형을
                                                                              //////////////////////////// 지정
                    for (int j = 0; j < flag_rules.length; j++) {
                        if (tags_flags) {
                            break;
                        }
                        if (commands_tags.equals(tags[j]) || commands_tags.equals(alias_tags[j])) {
                            commands_name = tags_type[j];
                            if (commands_tags.equals(tags[j])) {
                                alias_tags[j] = tags[j];
                            }
                            if (commands_tags.equals(alias_tags[j])) {
                                tags[j] = alias_tags[j];
                            }
                            break;
                        }
                    }
                    if (!(commands_name.equals("NULL"))) {
                        if (!tags_flags) {
                            program_commands = st.nextToken();
                        }
                        commands_seperater = program_commands.toCharArray();
                        for (int j = 0; j < program_commands.length(); j++) {
                            if (commands_name.equals("STRING")) {
                                if (!((commands_seperater[j] >= 'a' && commands_seperater[j] <= 'z')
                                        || (commands_seperater[j] >= 'A' && commands_seperater[j] <= 'Z'))) {
                                    test[i] = false;
                                    break;
                                }
                            }
                            if (commands_name.equals("NUMBER")) {
                                if (!(commands_seperater[j] >= '0' && commands_seperater[j] <= '9')) {
                                    test[i] = false;
                                    break;
                                }
                            }
                            if (commands_name.equals("STRINGS")) {
                                tags_flags = false;
                                if (!((commands_seperater[j] >= 'a' && commands_seperater[j] <= 'z')
                                        || (commands_seperater[j] >= 'A' && commands_seperater[j] <= 'Z'))) {
                                    test[i] = false;
                                    break;
                                }
                            }
                            if (commands_name.equals("NUMBERS")) {
                                tags_flags = false;
                                if (!(commands_seperater[j] >= '0' && commands_seperater[j] <= '9')) {
                                    test[i] = false;
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    if (commands_name.equals("STRINGS") || commands_name.equals("NUMBERS")) {
                        tags_flags = true;
                    } else {
                        test[i] = false;
                        break;
                    }
                }
            } while (st.hasMoreTokens());
        }
        if (test[1]) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        answer = test;
        return answer;
    }
}
