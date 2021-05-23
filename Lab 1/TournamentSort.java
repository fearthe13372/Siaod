package sample;

public class TournamentSort {
    public void Adjust(Node[] data, int idx)
    {
        while(idx != 0)
        {
            if(idx % 2 == 1)
            {
                if(data[idx].iData < data[idx + 1].iData)
                {
                    data[(idx - 1)/2] = data[idx];
                }
                else
                {
                    data[(idx-1)/2] = data[idx + 1];
                }
                idx = (idx - 1)/2;
            }
            else
            {
                if(data[idx-1].iData < data[idx].iData)
                {
                    data[idx/2 - 1] = data[idx-1];
                }
                else
                {
                    data[idx/2 - 1] = data[idx];
                }
                idx = (idx/2 - 1);
            }
        }
    }


    public void Sort(int[] data)
    {
        int nNodes = 1;
        int nTreeSize;
        while(nNodes < data.length)
        {
            nNodes *= 2;
        }
        nTreeSize = 2 * nNodes - 1;

        Node[] nodes = new Node[nTreeSize];
        //initialize the data

        int i, j;
        int idx;
        for( i = nNodes - 1; i < nTreeSize; i++)
        {
            idx = i - (nNodes - 1);
            if(idx < data.length)
            {
                nodes[i] = new Node(data[idx], i);
            }
            else
            {
                nodes[i] = new Node(Integer.MAX_VALUE, -1);
            }

        }

        for( i = nNodes - 2; i >= 0; i--)//
        {
            nodes[i] = new Node();
            if(nodes[i * 2 + 1].iData < nodes[i * 2 + 2].iData)
            {
                nodes[i] = nodes[i*2 + 1];
            }
            else
            {
                nodes[i] = nodes[i*2 + 2];
            }
        }
        //the real sorting procedure
        for( i = 0; i < data.length; i++)//ʵ������Ĺ���
        {
            data[i] = nodes[0].iData;//ȡ����С��
            nodes[nodes[0].idd].iData = Integer.MAX_VALUE;
            Adjust(nodes, nodes[0].idd);

        }



    }
}
